package com.example.ebay.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidCalculationException extends CustomBaseException{
    public InvalidCalculationException() {
        super(HttpStatus.BAD_REQUEST, new SimpleResponse(ErrorMessage.CALCULATION_NOT_FOUND.getMessage()));
    }
}
