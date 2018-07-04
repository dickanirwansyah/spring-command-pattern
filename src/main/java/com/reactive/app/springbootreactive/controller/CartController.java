package com.reactive.app.springbootreactive.controller;

import com.reactive.app.springbootreactive.entity.Cart;
import com.reactive.app.springbootreactive.model.controller.Response;
import com.reactive.app.springbootreactive.model.request.CreateNewCartRequest;
import com.reactive.app.springbootreactive.model.request.GetCartDetailRequest;
import com.reactive.app.springbootreactive.repository.CartRepository;
import com.reactive.app.springbootreactive.service.ServiceExecutor;
import com.reactive.app.springbootreactive.service.command.CreateNewCartCommand;
import com.reactive.app.springbootreactive.service.command.GetCartDetailCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RestController
@RequestMapping(value = "/carts")
public class CartController {

    @Autowired
    private ServiceExecutor serviceExecutor;

    @PostMapping(value = "/{cartId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Response<Cart>> create(@PathVariable("cartId") String cartId){
        CreateNewCartRequest request = CreateNewCartRequest
                .builder()
                .cartId(cartId)
                .build();

        return serviceExecutor.execute(CreateNewCartCommand.class, request)
                .map(Response::ok)
                .subscribeOn(Schedulers.elastic());
    }

    @GetMapping(value = "/{cartId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Response<Cart>> detail(@PathVariable("cartId") String cartId){

        GetCartDetailRequest request = GetCartDetailRequest
                .builder()
                .cartId(cartId)
                .build();

        return serviceExecutor.execute(GetCartDetailCommand.class, request)
                .map(Response::ok)
                .subscribeOn(Schedulers.elastic());
    }
}
