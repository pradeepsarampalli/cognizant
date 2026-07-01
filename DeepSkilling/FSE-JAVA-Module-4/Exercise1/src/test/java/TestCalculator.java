import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestCalculator {
    Calculator calculator;
    @Before
    public void setUp() {
        calculator = new Calculator();
    }
    @After
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
