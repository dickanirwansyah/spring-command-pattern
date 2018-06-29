package com.reactive.app.springbootreactive.service;

import com.reactive.app.springbootreactive.model.request.ServiceRequest;
import reactor.core.publisher.Mono;

public interface ServiceExecutor {

    <T, R extends ServiceRequest>Mono<T> execute(Class<? extends Command<T, R>> commandClass, R request);
}
