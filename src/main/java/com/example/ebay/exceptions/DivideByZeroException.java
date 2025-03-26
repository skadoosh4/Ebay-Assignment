package com.example.ebay.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;


public class DivideByZeroException extends CustomBaseException{
    private final Logger logger = LoggerFactory.getLogger(DivideByZeroException.class);
    public DivideByZeroException() {
        super(HttpStatus.NOT_ACCEPTABLE, new SimpleResponse(ErrorMessage.NOT_DIVIDE_BY_ZERO.getMessage()));
        logger.error("Divide By Zero Exception Thrown" + getClass().getSimpleName());
    }
}
