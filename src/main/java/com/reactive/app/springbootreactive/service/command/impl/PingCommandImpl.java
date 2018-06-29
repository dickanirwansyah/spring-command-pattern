package com.reactive.app.springbootreactive.service.command.impl;

import com.reactive.app.springbootreactive.model.request.ServiceRequest;
import com.reactive.app.springbootreactive.service.AbstractCommand;
import com.reactive.app.springbootreactive.service.command.PingCommand;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class PingCommandImpl extends AbstractCommand<String, ServiceRequest> implements PingCommand{

    @Override
    public Mono<String> doExecute(ServiceRequest request) {
        return Mono.just("PING DATA REQUEST");
    }
}
