package com.reactive.app.springbootreactive.service.command;

import com.reactive.app.springbootreactive.entity.Product;
import com.reactive.app.springbootreactive.model.request.DeleteProductByIdRequest;
import com.reactive.app.springbootreactive.service.Command;

public interface DeleteProductByIdCommand extends Command<Product, DeleteProductByIdRequest> {
}
