package com.example.ebay.exceptions;

import org.springframework.http.HttpStatus;

public class DivideByZeroException extends CustomBaseException{

    public DivideByZeroException() {
        super(HttpStatus.NOT_ACCEPTABLE, new SimpleResponse(ErrorMessage.NOT_DIVIDE_BY_ZERO.getMessage()));
    }
}
