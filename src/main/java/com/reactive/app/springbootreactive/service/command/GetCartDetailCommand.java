package com.reactive.app.springbootreactive.service.command;

import com.reactive.app.springbootreactive.entity.Cart;
import com.reactive.app.springbootreactive.model.request.GetCartDetailRequest;
import com.reactive.app.springbootreactive.service.Command;

public interface GetCartDetailCommand extends Command<Cart, GetCartDetailRequest>{
}
