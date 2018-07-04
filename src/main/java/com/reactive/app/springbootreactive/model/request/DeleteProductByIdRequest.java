package com.reactive.app.springbootreactive.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class DeleteProductByIdRequest implements ServiceRequest{

    @NotBlank
    private String productId;
}
