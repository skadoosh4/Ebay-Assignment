package com.example.ebay.operations;

import com.example.ebay.exceptions.InvalidOperationException;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class OperationDeserializer extends JsonDeserializer<Operation> {
    @Override
    public Operation deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        String value = jsonParser.getText().toUpperCase();
        try {
            return Operation.valueOf(value);
        }catch (IllegalArgumentException ex){
            throw new InvalidOperationException();
        }
    }
}
