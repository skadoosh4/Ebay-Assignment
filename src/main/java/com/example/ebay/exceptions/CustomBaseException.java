package com.example.ebay.exceptions;

import org.springframework.http.HttpStatus;

public class CustomBaseException extends RuntimeException{
    private HttpStatus status;
    private SimpleResponse simpleResponse;

    CustomBaseException(HttpStatus status , SimpleResponse simpleResponse){
        this.status = status;
        this.simpleResponse = simpleResponse;
    }

    public HttpStatus getStatus(){
        return this.status;
    }

    public SimpleResponse getSimpleResponse(){
        return this.simpleResponse;
    }
}
