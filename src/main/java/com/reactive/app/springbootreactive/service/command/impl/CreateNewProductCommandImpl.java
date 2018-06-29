package com.reactive.app.springbootreactive.service.command.impl;

import com.reactive.app.springbootreactive.entity.Product;
import com.reactive.app.springbootreactive.model.request.CreateNewProductRequest;
import com.reactive.app.springbootreactive.repository.ProductRepository;
import com.reactive.app.springbootreactive.service.AbstractCommand;
import com.reactive.app.springbootreactive.service.command.CreateNewProductCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class CreateNewProductCommandImpl extends AbstractCommand<Product, CreateNewProductRequest>
    implements CreateNewProductCommand{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Mono<Product> doExecute(CreateNewProductRequest request) {
        Product product = newProduct(
                request.getProductName(),
                request.getProductStock(),
                request.getProductPrice());
        return productRepository.save(product);
    }

    private Product newProduct(String name, Integer stock, Integer price){
        return Product.builder()
                .name(name)
                .stock(stock)
                .price(price)
                .build();
    }
}
