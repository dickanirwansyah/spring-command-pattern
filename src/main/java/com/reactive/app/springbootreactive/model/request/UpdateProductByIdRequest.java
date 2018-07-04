package com.reactive.app.springbootreactive.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductByIdRequest implements ServiceRequest {


    private String productId;

    @NotBlank
    private String productName;

    @NotNull
    @Min(1)
    private Integer productPrice;

    @NotNull
    @Min(1)
    @Max(100)
    private Integer productStock;
}
