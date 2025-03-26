package com.example.ebay.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

public class InvalidOperationException extends CustomBaseException{
    private final Logger logger = LoggerFactory.getLogger(InvalidOperationException.class);
    public InvalidOperationException() {
        super(HttpStatus.BAD_REQUEST , new SimpleResponse(ErrorMessage.INVALID_OPERATION.getMessage()));
    }
}
