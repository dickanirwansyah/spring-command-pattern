package com.reactive.app.springbootreactive.model.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class GetProductDetailRequest implements ServiceRequest{

    @NotBlank
    private String productId;
}
