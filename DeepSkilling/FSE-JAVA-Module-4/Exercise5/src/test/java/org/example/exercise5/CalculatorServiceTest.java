package org.example.exercise5;

import org.example.exercise5.Service.CalculatorService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorServiceTest {
    @Test
    void testAdd(){
        CalculatorService calculatorService = new CalculatorService();
        assertEquals(30,calculatorService.add(10,20));
    }
}
