package com.example.ebay.operations;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = OperationDeserializer.class)
public enum Operation {
    ADD,
    SUBTRACT,
    MULTIPLY,
    DIVIDE,
}
