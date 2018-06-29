package com.reactive.app.springbootreactive.controller;


import com.reactive.app.springbootreactive.model.controller.Response;
import com.reactive.app.springbootreactive.service.exception.CommandValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.Path;

@RestControllerAdvice
public class ExceptionController {


    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Response<Object> handleThrowableException(Throwable throwable){
        return Response.status(HttpStatus.INTERNAL_SERVER_ERROR, throwable.getMessage());
    }


    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Response<Object> handleCommandValidationException(CommandValidationException e){
        Response<Object> response = Response.status(HttpStatus.BAD_REQUEST, null);

        e.getConstraintViolations()
                .forEach(violation ->{
                    for (String attribute : getAttributes(violation)){
                        response.addError(attribute, violation.getMessage());
                    }
                });

        return response;
    }



    private String[] getAttributes(ConstraintViolation<?> constraintViolation){
        String[] values = (String[]) constraintViolation
                .getConstraintDescriptor()
                .getAttributes()
                .get("path");

        if (values == null || values.length == 0){
            return getAttributesFromPath(constraintViolation);
        }else {
            return values;
        }
    }

    private String[] getAttributesFromPath(ConstraintViolation<?> constraintViolation){
        Path path = constraintViolation.getPropertyPath();

        StringBuilder builder = new StringBuilder();
        path.forEach(node -> {
            if (node.getName() != null){
                if (builder.length() > 0){
                    builder.append(".");
                }
                builder.append(node.getName());
            }
        });

        return new String[]{builder.toString()};
    }
}
