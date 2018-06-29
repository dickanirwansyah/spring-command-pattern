package com.reactive.app.springbootreactive.repository;

import com.reactive.app.springbootreactive.entity.Cart;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface CartRepository extends ReactiveMongoRepository<Cart, String> {

}
