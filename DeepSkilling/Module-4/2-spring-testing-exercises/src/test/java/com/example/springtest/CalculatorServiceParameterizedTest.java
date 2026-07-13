package com.example.springtest;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Exercise 9: Parameterized Test with JUnit
 */
public class CalculatorServiceParameterizedTest {

    private final CalculatorService calculatorService = new CalculatorService();

    // Multiple sets of inputs -> expected output, using CSV values
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({
            "1, 1, 2",
            "2, 3, 5",
            "-1, 1, 0",
            "0, 0, 0",
            "100, 200, 300"
    })
    public void testAdd_withVariousInputs(int a, int b, int expected) {
        assertEquals(expected, calculatorService.add(a, b));
    }

    // Simple single-argument parameterized test
    @ParameterizedTest
    @ValueSource(ints = {0, 5, 10, -5})
    public void testAdd_withZero_returnsSameNumber(int number) {
        assertTrue(calculatorService.add(number, 0) == number);
    }
}
