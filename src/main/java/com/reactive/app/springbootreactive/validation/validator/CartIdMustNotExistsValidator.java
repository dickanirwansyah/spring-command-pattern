package com.reactive.app.springbootreactive.validation.validator;

import com.reactive.app.springbootreactive.entity.Cart;
import com.reactive.app.springbootreactive.repository.CartRepository;
import com.reactive.app.springbootreactive.validation.CartIdMustNotExists;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class CartIdMustNotExistsValidator implements ConstraintValidator<CartIdMustNotExists, String>{

    @Autowired
    private CartRepository cartRepository;


    @Override
    public void initialize(CartIdMustNotExists constraintAnnotation) {

    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        if (value == null){
            return true;
        }

        return !cartRepository.existsById(value).block();
    }
}
