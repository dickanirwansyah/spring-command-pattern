package com.reactive.app.springbootreactive.service.command;

import com.reactive.app.springbootreactive.entity.Product;
import com.reactive.app.springbootreactive.model.request.GetProductDetailRequest;
import com.reactive.app.springbootreactive.service.Command;

public interface GetProductDetailCommand extends Command<Product, GetProductDetailRequest>{
}
