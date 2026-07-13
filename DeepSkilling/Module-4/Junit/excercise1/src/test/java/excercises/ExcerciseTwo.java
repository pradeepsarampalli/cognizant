package excercises;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.BeforeClass;

public class ExcerciseTwo{
	
	Calculator c;
	
	@BeforeClass
	public static void start() {
		System.out.println("Excecutes before all the tests");
	}
	@Before
	public void createCalculator() {
		c = new Calculator();
	}
	@Test
	public void test1() {
		Assert.assertEquals(c.add(15,5),20);
	}
	@Test
	public void test2() {
		Assert.assertEquals(c.subtract(15,5),10);
	}
	@AfterClass
	public static void end() {
		System.out.println("Excecuted after all tests are executed");
	}

}

