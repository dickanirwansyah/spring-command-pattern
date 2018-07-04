package com.reactive.app.springbootreactive.service.command.impl;

import com.reactive.app.springbootreactive.entity.Product;
import com.reactive.app.springbootreactive.model.request.UpdateProductByIdRequest;
import com.reactive.app.springbootreactive.repository.ProductRepository;
import com.reactive.app.springbootreactive.service.AbstractCommand;
import com.reactive.app.springbootreactive.service.command.UpdateProductByIdCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class UpdateProductByIdCommandImpl extends AbstractCommand<Product, UpdateProductByIdRequest>
 implements UpdateProductByIdCommand{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Mono<Product> doExecute(UpdateProductByIdRequest request) {
        Product product = updateProduct(
                request.getProductId(),
                request.getProductName(),
                request.getProductStock(),
                request.getProductPrice());
        return productRepository.save(product);

    }

    private Product updateProduct(String productId, String name, Integer stock, Integer price){
        return Product.builder()
                .id(productId)
                .name(name)
                .stock(stock)
                .price(price)
                .build();
    }
}
