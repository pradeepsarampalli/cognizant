package com.example.springtest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Exercise 1: Basic Unit Test for a Service Method
 * No Spring context needed - CalculatorService has no dependencies.
 */
public class CalculatorServiceTest {

    @Test
    public void testAdd() {
        CalculatorService calculatorService = new CalculatorService();

        int result = calculatorService.add(2, 3);

        assertEquals(5, result);
    }

    @Test
    public void testAddWithNegativeNumbers() {
        CalculatorService calculatorService = new CalculatorService();

        assertEquals(-1, calculatorService.add(-4, 3));
        assertEquals(0, calculatorService.add(-5, 5));
    }
}
