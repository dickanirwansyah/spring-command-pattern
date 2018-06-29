package com.reactive.app.springbootreactive.model.request;

import com.reactive.app.springbootreactive.validation.ProductNameMustExists;
import com.reactive.app.springbootreactive.validation.ProductPriceMustExists;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
public class CreateNewProductRequest implements ServiceRequest{

    //@ProductNameMustExists
    @NotBlank
    private String productName;

    @Max(100)
    @Min(1)
    @NotNull
    private Integer productStock;

    //@ProductPriceMustExists
    @NotNull
    @Min(1000)
    private Integer productPrice;
}
