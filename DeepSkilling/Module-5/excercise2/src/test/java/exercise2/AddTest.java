package exercise2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddTest {
	@Test
	public void test() {
		Calculator c = new Calculator();
		Assertions.assertEquals(30,c.add(15, 15));
	}
}
