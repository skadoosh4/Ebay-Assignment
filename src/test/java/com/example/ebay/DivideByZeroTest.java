package com.example.ebay;

import com.example.ebay.calculator.service.CalculatorService;
import com.example.ebay.exceptions.DivideByZeroException;
import com.example.ebay.model.BasicCalculationRequest;
import com.example.ebay.operations.Operation;
import com.example.ebay.operations.OperationStrategy;
import com.example.ebay.operations.OperationStrategyFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = EbayApplicationTests.class)
public class DivideByZeroTest {

    @Mock
    private OperationStrategyFactory strategyFactory;

    @Mock
    private OperationStrategy divideStrategy;

    @InjectMocks
    private CalculatorService calculatorService;

    @BeforeEach
    void setup(){
        DivideByZeroException exception = new DivideByZeroException();
        when(strategyFactory.getStrategy(Operation.DIVIDE)).thenReturn(divideStrategy);
        when(divideStrategy.apply(5, 0)).thenThrow(exception);
    }

    @Test
    void testDivideByZero() {
        BasicCalculationRequest request = new BasicCalculationRequest(Operation.DIVIDE, 5, 0);

        DivideByZeroException exception = assertThrows(DivideByZeroException.class,
                () -> calculatorService.calculate(request));

        assertEquals("Cannot Divide By Zero", exception.getSimpleResponse().getMessage());
    }
}
