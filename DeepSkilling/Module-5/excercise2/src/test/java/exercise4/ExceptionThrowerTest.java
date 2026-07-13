package exercise4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExceptionThrowerTest {
	@Test
	public void test() {
		ExceptionThrower et = new ExceptionThrower();
		Exception e = Assertions.assertThrows(Exception.class,
				()->{
					et.throwExcpetion();
				});
		Assertions.assertEquals("Throwing a exception", e.getMessage());
	}
}
