package com.reactive.app.springbootreactive.service.command;

import com.reactive.app.springbootreactive.entity.Cart;
import com.reactive.app.springbootreactive.model.request.CreateNewCartRequest;
import com.reactive.app.springbootreactive.service.Command;

public interface CreateNewCartCommand extends Command<Cart, CreateNewCartRequest>{
}
