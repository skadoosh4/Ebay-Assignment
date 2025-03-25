package com.example.ebay.operations.operationImpl;

import com.example.ebay.exceptions.InvalidInputException;
import com.example.ebay.operations.OperationStrategy;

public class SubtractOperation implements OperationStrategy {
    @Override
    public Number calculate(Number num1, Number num2) {
        if(num1 == null || num2 == null){
            throw new InvalidInputException();
        }
        return num1.doubleValue() - num2.doubleValue();
    }
}
