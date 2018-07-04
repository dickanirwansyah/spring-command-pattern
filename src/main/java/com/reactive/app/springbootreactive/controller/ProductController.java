package com.reactive.app.springbootreactive.controller;

import com.reactive.app.springbootreactive.entity.Product;
import com.reactive.app.springbootreactive.model.controller.Response;
import com.reactive.app.springbootreactive.model.request.CreateNewProductRequest;
import com.reactive.app.springbootreactive.model.request.DeleteProductByIdRequest;
import com.reactive.app.springbootreactive.model.request.GetProductDetailRequest;
import com.reactive.app.springbootreactive.model.request.UpdateProductByIdRequest;
import com.reactive.app.springbootreactive.service.ServiceExecutor;
import com.reactive.app.springbootreactive.service.command.CreateNewProductCommand;
import com.reactive.app.springbootreactive.service.command.DeleteProductByIdCommand;
import com.reactive.app.springbootreactive.service.command.GetProductDetailCommand;
import com.reactive.app.springbootreactive.service.command.UpdateProductByIdCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;


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

    @PutMapping(value = "/edit/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Response<Product>> edit(@PathVariable("productId") String productId,
                                        @RequestBody UpdateProductByIdRequest request){
        UpdateProductByIdRequest requestProduct = UpdateProductByIdRequest
                .builder()
                .productId(productId)
                .productName(request.getProductName())
                .productStock(request.getProductStock())
                .productPrice(request.getProductPrice())
                .build();

        return serviceExecutor
                .execute(UpdateProductByIdCommand.class, requestProduct)
                .map(Response::ok)
                .subscribeOn(Schedulers.elastic());
    }

    @DeleteMapping(value = "/delete/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Response<Product>> delete(@PathVariable("productId")String productId){

        DeleteProductByIdRequest requestProduct = DeleteProductByIdRequest
                .builder()
                .productId(productId)
                .build();

        return serviceExecutor.execute(DeleteProductByIdCommand.class, requestProduct)
                .map(Response::ok)
                .subscribeOn(Schedulers.elastic());
    }

    @GetMapping(value = "/{productId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Response<Product>> productId(@PathVariable("productId") String productId){

        GetProductDetailRequest requestProduct = GetProductDetailRequest
                .builder()
                .productId(productId)
                .build();

        return serviceExecutor
                .execute(GetProductDetailCommand.class, requestProduct)
                .map(Response::okOrNotFound)
                .subscribeOn(Schedulers.elastic());
    }

}
