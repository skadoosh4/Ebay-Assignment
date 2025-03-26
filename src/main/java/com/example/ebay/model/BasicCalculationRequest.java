package com.example.ebay.model;

import com.example.ebay.operations.Operation;

public class BasicCalculationRequest {
    private Operation operation;
    private Number num1;
    private Number num2;

    public BasicCalculationRequest(){}

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public BasicCalculationRequest(Operation operation, Number num1, Number num2) {
        this.operation = operation;
        this.num1 = num1;
        this.num2 = num2;
    }

    public Number getNum1() {
        return num1;
    }

    public void setNum1(Number num1) {
        this.num1 = num1;
    }

    public Number getNum2() {
        return num2;
    }

    public void setNum2(Number num2) {
        this.num2 = num2;
    }
}
