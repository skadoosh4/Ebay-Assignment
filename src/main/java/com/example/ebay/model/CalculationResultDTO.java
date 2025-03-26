package com.example.ebay.model;

public class CalculationResultDTO {
    private Number result;
    private String calculationSteps;

    public Number getResult() {
        return result;
    }

    public void setResult(Number result) {
        this.result = result;
    }

    public String getCalculationSteps() {
        return calculationSteps;
    }

    public void setCalculationSteps(String calculationSteps) {
        this.calculationSteps = calculationSteps;
    }
}
