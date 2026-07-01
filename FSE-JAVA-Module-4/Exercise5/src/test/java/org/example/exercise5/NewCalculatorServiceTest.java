package org.example.exercise5;

import org.example.exercise5.Service.CalculatorService;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NewCalculatorServiceTest {
    CalculatorService calculatorService = new CalculatorService();
    @ParameterizedTest
    @CsvSource({
            "2,3,5",
            "5,5,10",
            "10,20,30",
            "100,200,300"
    })
    void testAdd(int a,int b,int expected){
        assertEquals(expected,calculatorService.add(a,b));
    }
}
