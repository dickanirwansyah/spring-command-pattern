package com.reactive.app.springbootreactive.model.request;

import com.reactive.app.springbootreactive.validation.CartIdMustNotExists;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class CreateNewCartRequest implements ServiceRequest{

    @CartIdMustNotExists
    private String cartId;
}
