package excercises;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class ExcerciseFour {

	    private Calculator calculator;

	    @Before
	    public void setUp() {
	        calculator = new Calculator();
	    }

	    @After
	    public void tearDown() {
	        calculator = null;
	    }

	    @Test
	    public void testAdd() {
	        // 1. ARRANGE
	        int num1 = 5;
	        int num2 = 3;
	        int expected = 8;

	        // 2. ACT
	        int actual = calculator.add(num1, num2);

	        // 3. ASSERT
	        assertEquals("Addition logic failed", expected, actual);
	    }

	    @Test
	    public void testSubtract() {
	        // 1. ARRANGE
	        int num1 = 10;
	        int num2 = 4;
	        int expected = 6;

	        // 2. ACT
	        int actual = calculator.subtract(num1, num2);

	        // 3. ASSERT
	        assertEquals("Subtraction logic failed", expected, actual);
	    }
	}

