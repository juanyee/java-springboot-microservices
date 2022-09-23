package com.juanyee.microservices.products.controller;

import com.juanyee.microservices.products.model.Product;
import com.juanyee.microservices.products.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Product> findAll() {
        System.out.println("find all!");
        return productRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody Product product) {
        System.out.println(product);
        System.out.println(productRepository);
        productRepository.save(product);
        System.out.println("saved");
    }
}
