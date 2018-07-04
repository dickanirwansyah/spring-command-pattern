package com.reactive.app.springbootreactive.model.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

import java.util.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {

    private String status;

    private Integer code;

    private T data;

    private Map<String, List<String>> errors;

    public void addError(String key, String error){
        initializeErrorsIfNull();
        initializeListIfNull(key);

        errors.get(key).add(error);
    }

    private void initializeErrorsIfNull(){
        if (errors == null) errors = new HashMap<>();
    }

    private void initializeListIfNull(String key){
        errors.computeIfAbsent(key, k -> new ArrayList<>());
    }

    //-------static-----------//

    public static <T> Response<T> ok(T data){
        Assert.notNull(data, "Data must not null");
        return Response.status(HttpStatus.OK, data);
    }

    public static <T> Response<T> NotFound(T data){
        return Response.status(HttpStatus.NOT_FOUND, data);
    }

    public static <T> Response<T> okOrNotFound(@Nullable T data){
        if (Objects.isNull(data)){
            return Response.status(HttpStatus.NOT_FOUND,null);
        }else{
            return Response.ok(data);
        }
    }

    public static <T> Response<T> status(HttpStatus httpStatus, @Nullable T data){
        return Response.<T>builder()
                .code(httpStatus.value())
                .status(httpStatus.getReasonPhrase())
                .data(data)
                .build();
    }
}
