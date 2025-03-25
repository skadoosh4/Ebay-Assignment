package com.example.ebay.exceptions;

public enum ErrorMessage {

    NOT_DIVIDE_BY_ZERO("Cannot Divide By Zero"),
    INVALID_OPERATION("This Operation is Not Supported at this moment"),
    CALCULATION_NOT_FOUND("Calculation not Found"),
    INVALID_INPUT("Input cannot be null");

    ErrorMessage(String message){
        this.message = message;
    }
    public String getMessage(){
        return this.message;
    }
    private final String message;
}
