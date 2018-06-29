package com.reactive.app.springbootreactive.service.command.impl;

import com.reactive.app.springbootreactive.entity.Cart;
import com.reactive.app.springbootreactive.model.request.CreateNewCartRequest;
import com.reactive.app.springbootreactive.repository.CartRepository;
import com.reactive.app.springbootreactive.service.AbstractCommand;
import com.reactive.app.springbootreactive.service.command.CreateNewCartCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class CreateNewCartCommandImpl extends AbstractCommand<Cart, CreateNewCartRequest>
    implements CreateNewCartCommand{

    @Autowired
    private CartRepository cartRepository;

    @Override
    public Mono<Cart> doExecute(CreateNewCartRequest request) {
        Cart cart = newCart(request.getCartId());
        return cartRepository.save(cart);
    }

    private Cart newCart(String cartId){
        return Cart.builder()
                .id(cartId)
                .build();
    }
}
