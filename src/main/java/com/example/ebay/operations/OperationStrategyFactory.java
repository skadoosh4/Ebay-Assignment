package com.example.ebay.operations;

import com.example.ebay.exceptions.InvalidCalculationException;
import com.example.ebay.operations.operationImpl.AddOperation;
import com.example.ebay.operations.operationImpl.DivideOperation;
import com.example.ebay.operations.operationImpl.MultiplyOperation;
import com.example.ebay.operations.operationImpl.SubtractOperation;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;

@Component
public class OperationStrategyFactory {
    private final Map<Operation , OperationStrategy> strategyMap = new EnumMap<>(Operation.class);

    public OperationStrategyFactory(AddOperation addOperation , SubtractOperation subtractOperation , MultiplyOperation multiplyOperation , DivideOperation divideOperation){
        strategyMap.put(Operation.ADD , addOperation);
        strategyMap.put(Operation.SUBTRACT , subtractOperation);
        strategyMap.put(Operation.MULTIPLY , multiplyOperation);
        strategyMap.put(Operation.DIVIDE , multiplyOperation);
    }

    public OperationStrategy getStrategy(Operation operation){
        OperationStrategy strategy = strategyMap.get(operation);
        if(strategy == null){
            throw new InvalidCalculationException();
        }
        return strategy;
    }
}
