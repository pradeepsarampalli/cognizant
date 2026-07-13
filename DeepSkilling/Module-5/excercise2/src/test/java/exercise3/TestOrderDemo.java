package exercise3;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Assertions;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestOrderDemo {
	Calculator c;
	@BeforeEach
	public void initialise() {
		c = new Calculator();
	}
	@Test
	@Order(2)
	public void test1() {
		Assertions.assertEquals(30,c.add(10, 20));
		System.out.println("test1 Executed -2nd");
	}
	
	@Test
	@Order(1)
	public void test2() {
		Assertions.assertEquals(10,c.subtract(30, 20));
		System.out.println("test2 Executed -1st");
	}
	
}
