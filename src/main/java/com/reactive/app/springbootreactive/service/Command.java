package com.reactive.app.springbootreactive.service;

import com.reactive.app.springbootreactive.model.request.ServiceRequest;
import reactor.core.publisher.Mono;

public interface Command<RESULT, REQUEST extends ServiceRequest> {

    Mono<RESULT> execute(REQUEST request);
}
