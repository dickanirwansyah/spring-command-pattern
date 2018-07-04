package com.reactive.app.springbootreactive.service.command.impl;

import com.reactive.app.springbootreactive.entity.Product;
import com.reactive.app.springbootreactive.model.request.GetProductDetailRequest;
import com.reactive.app.springbootreactive.repository.ProductRepository;
import com.reactive.app.springbootreactive.service.AbstractCommand;
import com.reactive.app.springbootreactive.service.command.GetProductDetailCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class GetProductDetailCommandImpl extends AbstractCommand<Product, GetProductDetailRequest>
implements GetProductDetailCommand{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Mono<Product> doExecute(GetProductDetailRequest request) {
        return productRepository.findById(request.getProductId());
    }
}
