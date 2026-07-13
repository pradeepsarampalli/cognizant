package exercise2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SubtractTest {
	@Test
	public void test() {
		Calculator c = new Calculator();
		Assertions.assertEquals(c.subtract(15, 5), 10);
	}
}
