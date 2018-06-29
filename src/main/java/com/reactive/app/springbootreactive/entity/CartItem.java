package com.reactive.app.springbootreactive.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CartItem {

    private String id;

    private String name;

    private Integer quantity;

    private Integer price;
}
