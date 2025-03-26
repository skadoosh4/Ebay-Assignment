package com.example.ebay.calculator.controller;


import com.example.ebay.calculator.service.CalculatorService;
import com.example.ebay.model.BasicCalculationRequest;
import com.example.ebay.model.CalculationRequest;
import com.example.ebay.model.CalculationResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

    private final CalculatorService calculatorService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService){
        this.calculatorService = calculatorService;
    }

    @PostMapping("/calculate")
    public ResponseEntity<CalculationResultDTO> calculate(@RequestBody BasicCalculationRequest request){
        return calculatorService.calculate(request);
    }

    @PostMapping("/chain")
    public ResponseEntity<CalculationResultDTO> chainCalculate(@RequestBody CalculationRequest request){
        return calculatorService.calculateChain(request);
    }
}
