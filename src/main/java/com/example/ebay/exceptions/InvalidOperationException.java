package com.example.ebay.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidOperationException extends CustomBaseException{

    public InvalidOperationException(HttpStatus status, SimpleResponse simpleResponse) {
        super(HttpStatus.BAD_REQUEST , new SimpleResponse(ErrorMessage.INVALID_OPERATION.getMessage()));
    }
}
