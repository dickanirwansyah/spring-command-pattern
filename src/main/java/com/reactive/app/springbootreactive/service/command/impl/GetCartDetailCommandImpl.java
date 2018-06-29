package com.reactive.app.springbootreactive.service.command.impl;

import com.reactive.app.springbootreactive.entity.Cart;
import com.reactive.app.springbootreactive.model.request.GetCartDetailRequest;
import com.reactive.app.springbootreactive.repository.CartRepository;
import com.reactive.app.springbootreactive.service.AbstractCommand;
import com.reactive.app.springbootreactive.service.command.GetCartDetailCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class GetCartDetailCommandImpl extends AbstractCommand<Cart, GetCartDetailRequest>
    implements GetCartDetailCommand{

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Mono<Cart> doExecute(GetCartDetailRequest request) {
        return getId(request.getCartId());
    }

    private Mono<Cart> getId(String cartId){
        return cartRepository.findById(cartId);
    }
}
