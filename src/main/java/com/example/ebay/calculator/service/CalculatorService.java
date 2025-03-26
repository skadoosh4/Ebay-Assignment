package com.example.ebay.calculator.service;

import com.example.ebay.exceptions.InvalidInputException;
import com.example.ebay.model.BasicCalculationRequest;
import com.example.ebay.model.CalculationRequest;
import com.example.ebay.model.CalculationResultDTO;
import com.example.ebay.model.OperationStep;
import com.example.ebay.operations.OperationStrategy;
import com.example.ebay.operations.OperationStrategyFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CalculatorService implements ICalculatorService{

    private final Logger logger = LoggerFactory.getLogger(CalculatorService.class);

    private final OperationStrategyFactory strategyFactory;

    @Autowired
    public CalculatorService(OperationStrategyFactory strategyFactory){
        this.strategyFactory = strategyFactory;
    }
    @Override
    public ResponseEntity<CalculationResultDTO> calculate(BasicCalculationRequest request) {
        logger.info("Calculate " + getClass().getSimpleName());
        if (request.getNum1() == null || request.getNum2() == null) {
            throw new InvalidInputException();
        }
        OperationStrategy strategy = strategyFactory.getStrategy(request.getOperation());
        Number result = strategy.apply(request.getNum1(), request.getNum2());

        CalculationResultDTO response = new CalculationResultDTO();
        response.setResult(result);
        response.setCalculationSteps(String.format("%s %s %s = %s", request.getNum1(), request.getOperation(), request.getNum2(), result));
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<CalculationResultDTO> calculateChain(CalculationRequest request) {
        logger.info("Chain Calculate" + getClass().getSimpleName());
        if(request.getInitialValue() == null || request.getOperations() == null){
            throw new InvalidInputException();
        }
        Number currentValue = request.getInitialValue();
        List<String> steps = new ArrayList<>();
        steps.add("Starts with : " + currentValue);
        for(OperationStep step : request.getOperations()){
            OperationStrategy strategy = strategyFactory.getStrategy(step.getOperation());
            Number newValue = strategy.apply(currentValue , step.getValue());
            steps.add(String.format("%s %s %s = %s" , currentValue , step.getOperation() , step.getValue() , newValue));
            currentValue = newValue;
        }
        CalculationResultDTO response = new CalculationResultDTO();
        response.setResult(currentValue);
        response.setCalculationSteps(String.join(" " , steps));
        return ResponseEntity.ok(response);
    }
}
