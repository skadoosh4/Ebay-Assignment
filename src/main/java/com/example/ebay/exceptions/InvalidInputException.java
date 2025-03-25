package com.example.ebay.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidInputException extends CustomBaseException{
    public InvalidInputException() {
        super(HttpStatus.BAD_REQUEST , new SimpleResponse(ErrorMessage.INVALID_INPUT.getMessage()));
    }
}
