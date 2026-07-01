

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestCalculator {
    Calculator calculator;
    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }
    @AfterEach
    public void setAfter(){
        System.out.println("Test case passed");
    }
    @Test
    public void testAddition() {
        assertEquals(30, calculator.add(10, 20));
    }

    @Test
    public void testEven() {
        assertTrue(calculator.isEven(4));
    }

    @Test
    public void isNegative() {
        assertFalse(calculator.isNegative(4));
    }

    @Test
    public void isSquare() {
        assertEquals(16, calculator.square(4));
    }
}
