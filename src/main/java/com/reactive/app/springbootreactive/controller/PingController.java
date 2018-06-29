package com.reactive.app.springbootreactive.controller;


import com.reactive.app.springbootreactive.model.controller.Response;
import com.reactive.app.springbootreactive.model.request.PingRequest;
import com.reactive.app.springbootreactive.service.ServiceExecutor;
import com.reactive.app.springbootreactive.service.command.PingCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RestController
public class PingController {

    @Autowired
    private ServiceExecutor serviceExecutor;

    @GetMapping(value = "/hallo")
    public Mono<Response<String>> hallo(){
        return Mono.just(Response.ok("Hallo there !"))
                .subscribeOn(Schedulers.elastic());
    }

    @GetMapping(value = "/ping")
    public Mono<Response<String>> ping(){

        PingRequest request = PingRequest
                .builder()
                .build();

        return serviceExecutor.execute(PingCommand.class, request)
                .map(Response::ok)
                .subscribeOn(Schedulers.elastic());
    }
}
