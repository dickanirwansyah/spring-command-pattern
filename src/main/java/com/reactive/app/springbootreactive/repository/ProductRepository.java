package com.reactive.app.springbootreactive.repository;

import com.reactive.app.springbootreactive.entity.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ProductRepository extends ReactiveMongoRepository<Product, String>{
}
