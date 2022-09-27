package com.juanyee.microservices.orders.controller;

import com.juanyee.microservices.orders.client.InventoryClient;
import com.juanyee.microservices.orders.dto.OrderDto;
import com.juanyee.microservices.orders.model.Order;
import com.juanyee.microservices.orders.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreaker;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.function.Supplier;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
@Slf4j
public class OrderController {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;
    private final Resilience4JCircuitBreakerFactory circuitBreakerFactory;
    private final StreamBridge streamBridge; // for event driven (notification-service)
    private final ExecutorService executorService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String get() throws UnknownHostException {
        String message = "hello from " + InetAddress.getLocalHost();
        System.out.println(message);
        return message;
    }

    @PostMapping
    public String placeOrder(@RequestBody OrderDto orderDto) {
        circuitBreakerFactory.configureExecutorService(executorService);
        Resilience4JCircuitBreaker circuitBreaker = circuitBreakerFactory.create("inventory");

        Supplier<Boolean> booleanSupplier = () -> orderDto.getOrderLineItemsList().stream()
                .allMatch(orderLineItems -> {
                    log.info("Making Call to Inventory Service for SkuCode {}", orderLineItems.getSkuCode());
                    return inventoryClient.checkStock(orderLineItems.getSkuCode());
                });

        boolean allProductsInStock = circuitBreaker.run(booleanSupplier, throwable -> handlerErrorCase());

        if (allProductsInStock) {
            Order order = new Order();
            order.setOrderLineItems(orderDto.getOrderLineItemsList());
            order.setOrderNumber(UUID.randomUUID().toString());
            orderRepository.save(order);

            log.info("Sending Order Details to Notification Service");
//            streamBridge.send("notificationEventSupplier-out-0", order.getId());
            streamBridge.send("notificationEventSupplier-out-0", MessageBuilder.withPayload(order.getId()).build());
            return "Order Place Successfully";
        } else {
            return "Order Failed, One of the products in the order is not in stock";
        }
    }

    private Boolean handlerErrorCase() {
        System.out.println("handlerErrorCase!!");
        return false;
    }
}
