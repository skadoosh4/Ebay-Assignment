package com.example.ebay.exceptions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

public class InvalidInputException extends CustomBaseException{
    private final Logger logger = LoggerFactory.getLogger(InvalidInputException.class);
    public InvalidInputException() {
        super(HttpStatus.BAD_REQUEST , new SimpleResponse(ErrorMessage.INVALID_INPUT.getMessage()));
        logger.error("Invalid Input Exception Thrown " + getClass().getSimpleName());
    }
}
