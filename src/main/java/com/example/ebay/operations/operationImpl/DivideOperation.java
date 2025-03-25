package com.example.ebay.operations.operationImpl;

import com.example.ebay.exceptions.DivideByZeroException;
import com.example.ebay.exceptions.InvalidInputException;
import com.example.ebay.operations.OperationStrategy;
import org.springframework.stereotype.Component;

@Component
public class DivideOperation implements OperationStrategy {

    @Override
    public Number calculate(Number num1, Number num2) {
        if(num1 == null || num2 == null){
            throw new InvalidInputException();
        }
        if(num2.doubleValue() == 0){
            throw new DivideByZeroException();
        }
        return num1.doubleValue() / num2.doubleValue();
    }
}
