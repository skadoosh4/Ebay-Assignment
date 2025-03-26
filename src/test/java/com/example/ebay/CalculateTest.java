package com.example.ebay;

import com.example.ebay.calculator.service.CalculatorService;
import com.example.ebay.model.BasicCalculationRequest;
import com.example.ebay.model.CalculationResultDTO;
import com.example.ebay.operations.Operation;
import com.example.ebay.operations.OperationStrategy;
import com.example.ebay.operations.OperationStrategyFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = EbayApplicationTests.class)
public class CalculateTest {

    @Mock
    private OperationStrategyFactory strategyFactory;

    @Mock
    private OperationStrategy addStrategy;

    @Mock
    private OperationStrategy subtractStrategy;

    @Mock
    private OperationStrategy multiplyStrategy;

    @Mock
    private OperationStrategy divideStrategy;


    @InjectMocks
    private CalculatorService calculatorService;

    @BeforeEach
    void setup(){
        calculatorService = new CalculatorService(strategyFactory);
        when(strategyFactory.getStrategy(Operation.ADD)).thenReturn(addStrategy);
        when(addStrategy.apply(4,4)).thenReturn(8.0);

        when(strategyFactory.getStrategy(Operation.SUBTRACT)).thenReturn(subtractStrategy);
        when(subtractStrategy.apply(10 , 2)).thenReturn(8.0);

        when(strategyFactory.getStrategy(Operation.MULTIPLY)).thenReturn(multiplyStrategy);
        when(multiplyStrategy.apply(4 , 4)).thenReturn(16.0);

        when(strategyFactory.getStrategy(Operation.DIVIDE)).thenReturn(divideStrategy);
        when(divideStrategy.apply(4 ,2)).thenReturn(2.0);
    }

    @Test
    void testAddition(){
        BasicCalculationRequest request = new BasicCalculationRequest(Operation.ADD , 4 , 4);
        CalculationResultDTO resultDTO = calculatorService.calculate(request).getBody();
        assert resultDTO != null;
        assertEquals(8.0 , resultDTO.getResult());
    }

    @Test
    void testSubtraction(){
        BasicCalculationRequest request = new BasicCalculationRequest(Operation.SUBTRACT , 10 , 2);
        CalculationResultDTO resultDTO = calculatorService.calculate(request).getBody();
        assert resultDTO != null;
        assertEquals(8.0 , resultDTO.getResult());
    }

    @Test
    void testMultiplication(){
        BasicCalculationRequest request = new BasicCalculationRequest(Operation.MULTIPLY , 4 , 4);
        CalculationResultDTO resultDTO = calculatorService.calculate(request).getBody();
        assert resultDTO != null;
        assertEquals(16.0 , resultDTO.getResult());
    }

    @Test
    void testDivision(){
        BasicCalculationRequest request = new BasicCalculationRequest(Operation.DIVIDE , 4 , 2);
        CalculationResultDTO resultDTO = calculatorService.calculate(request).getBody();
        assert resultDTO != null;
        assertEquals(2.0 , resultDTO.getResult());
    }
}
