package com.example.ebay.model;

import com.example.ebay.operations.Operation;

public class OperationStep {
    private Operation operation;
    private Number value;

    public OperationStep(Operation operation, int i) {
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Number getValue() {
        return value;
    }

    public void setValue(Number value) {
        this.value = value;
    }
}
