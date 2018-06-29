package com.reactive.app.springbootreactive.service.command;

import com.reactive.app.springbootreactive.entity.Product;
import com.reactive.app.springbootreactive.model.request.CreateNewProductRequest;
import com.reactive.app.springbootreactive.service.Command;

public interface CreateNewProductCommand extends Command<Product, CreateNewProductRequest> {
}
