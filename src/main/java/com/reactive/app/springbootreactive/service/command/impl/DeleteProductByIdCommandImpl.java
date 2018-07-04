package com.reactive.app.springbootreactive.service.command.impl;

import com.reactive.app.springbootreactive.entity.Product;
import com.reactive.app.springbootreactive.model.controller.Response;
import com.reactive.app.springbootreactive.model.request.DeleteProductByIdRequest;
import com.reactive.app.springbootreactive.repository.ProductRepository;
import com.reactive.app.springbootreactive.service.AbstractCommand;
import com.reactive.app.springbootreactive.service.command.DeleteProductByIdCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class DeleteProductByIdCommandImpl extends AbstractCommand<Product, DeleteProductByIdRequest>
implements DeleteProductByIdCommand{

    @Autowired
    private ProductRepository productRepository;


    @Override
    public Mono<Product> doExecute(DeleteProductByIdRequest request) {
        return productRepository.findById(request.getProductId())
                .flatMap(existProduct -> productRepository.delete(existProduct))
                .then(productRepository
                        .findById(request.getProductId()));
    }

}
