package com.reactive.app.springbootreactive.model.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class GetCartDetailRequest implements ServiceRequest{

    @NotBlank
    private String cartId;
}
