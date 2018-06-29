package com.reactive.app.springbootreactive.controller;

import com.reactive.app.springbootreactive.entity.Product;
import com.reactive.app.springbootreactive.model.controller.Response;
import com.reactive.app.springbootreactive.model.request.CreateNewProductRequest;
import com.reactive.app.springbootreactive.service.ServiceExecutor;
import com.reactive.app.springbootreactive.service.command.CreateNewProductCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ServiceExecutor serviceExecutor;

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Response<Product>> create(@RequestBody CreateNewProductRequest request){

        CreateNewProductRequest requestProduct = CreateNewProductRequest
                .builder()
                .productName(request.getProductName())
                .productStock(request.getProductStock())
                .productPrice(request.getProductPrice())
                .build();

        return serviceExecutor.execute(CreateNewProductCommand.class, requestProduct)
                .map(Response::ok)
                .subscribeOn(Schedulers.elastic());
    }
}
