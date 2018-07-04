package com.reactive.app.springbootreactive.controller;

import com.reactive.app.springbootreactive.entity.Product;
import com.reactive.app.springbootreactive.model.controller.Response;
import com.reactive.app.springbootreactive.model.request.CreateNewProductRequest;
import com.reactive.app.springbootreactive.model.request.UpdateProductByIdRequest;
import com.reactive.app.springbootreactive.service.ServiceExecutor;
import com.reactive.app.springbootreactive.service.command.CreateNewProductCommand;
import com.reactive.app.springbootreactive.service.command.UpdateProductByIdCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
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

    @PutMapping(value = "/update/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Response<Product>> update(@PathVariable("productId")String productId,
                                          @RequestBody UpdateProductByIdRequest request){

        UpdateProductByIdRequest requestProduct = UpdateProductByIdRequest
                .builder()
                .productId(productId)
                .productName(request.getProductName())
                .productPrice(request.getProductPrice())
                .productStock(request.getProductStock())
                .build();

        return serviceExecutor.execute(UpdateProductByIdCommand.class, requestProduct)
                .map(Response::ok)
                .subscribeOn(Schedulers.elastic());
    }
}
