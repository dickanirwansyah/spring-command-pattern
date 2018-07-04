package com.reactive.app.springbootreactive.service.command;

import com.reactive.app.springbootreactive.entity.Product;
import com.reactive.app.springbootreactive.model.request.UpdateProductByIdRequest;
import com.reactive.app.springbootreactive.service.Command;

public interface UpdateProductByIdCommand extends Command<Product, UpdateProductByIdRequest> {
}
