package com.example.ebay.model;

import java.util.List;

public class CalculationRequest {
    private Number initialValue;
    private List<OperationStep> operations;

    public CalculationRequest(){
    }

    public CalculationRequest(Number initialValue , List<OperationStep> operations){
        this.initialValue = initialValue;
        this.operations = operations;
    }

    public Number getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(Number initialValue) {
        this.initialValue = initialValue;
    }

    public List<OperationStep> getOperations() {
        return operations;
    }

    public void setOperations(List<OperationStep> operations) {
        this.operations = operations;
    }
}
