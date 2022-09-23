package com.juanyee.microservices.orders.repository;

import com.juanyee.microservices.orders.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
