package com.reactive.app.springbootreactive.validation.validator;

import com.reactive.app.springbootreactive.validation.ProductNameMustExists;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class ProductNameMustExistsValidator implements ConstraintValidator<ProductNameMustExists, String>{

    @Override
    public void initialize(ProductNameMustExists constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value == null || value.isEmpty()){
            return false;
        }

        return true;
    }
}
