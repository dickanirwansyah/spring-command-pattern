package com.reactive.app.springbootreactive.validation;

import com.reactive.app.springbootreactive.validation.validator.ProductPriceMustExistsValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, ANNOTATION_TYPE, METHOD, FIELD})
@Constraint(validatedBy = {ProductPriceMustExistsValidator.class})
@Retention(RUNTIME)
@Documented
public @interface ProductPriceMustExists {

    String message() default "ProductPriceMustExists";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String[] path() default {};
}
