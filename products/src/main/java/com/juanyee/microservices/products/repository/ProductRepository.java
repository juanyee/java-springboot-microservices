package com.juanyee.microservices.products.repository;

import com.juanyee.microservices.products.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
