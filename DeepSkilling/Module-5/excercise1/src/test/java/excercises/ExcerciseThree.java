package excercises;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.junit.BeforeClass;

public class ExcerciseThree {
	@BeforeClass
	public static void start() {
		System.out.println("Excecutes before all the tests");
	}
	@Test
	public void test1() {
		Assert.assertEquals(20,20);
	}
	@Test
	public void test2() {
		Assert.assertTrue(10>2);
	}
	@Test
	public void test3() {
		Assert.assertFalse(20<10);
	}
	@Test
	public void test4() {
		Assert.assertNull(null);
	}
	@Test
	public void test5() {
		Assert.assertNotNull(new Calculator());
	}
	
	@AfterClass
	public static void end() {
		System.out.println("Excecuted after all tests are executed");
	}

}
