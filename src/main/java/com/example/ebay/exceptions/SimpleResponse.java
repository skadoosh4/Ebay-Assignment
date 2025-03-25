package com.example.ebay.exceptions;


public class SimpleResponse {
    private String message;

    public SimpleResponse(String message){
        this.message = message;
    }
    public String getMessage(){
        return this.message;
    }
}
