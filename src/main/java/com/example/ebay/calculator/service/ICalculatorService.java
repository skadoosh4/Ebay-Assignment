package com.example.ebay.calculator.service;

import com.example.ebay.model.BasicCalculationRequest;
import com.example.ebay.model.CalculationRequest;
import com.example.ebay.model.CalculationResultDTO;
import org.springframework.http.ResponseEntity;

public interface ICalculatorService {
    ResponseEntity<CalculationResultDTO> calculate(BasicCalculationRequest request);
    ResponseEntity<CalculationResultDTO> calculateChain(CalculationRequest request);
}
