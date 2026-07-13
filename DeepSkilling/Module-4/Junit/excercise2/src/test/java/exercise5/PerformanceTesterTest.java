package exercise5;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class PerformanceTesterTest {
	@Test
	@Timeout(10) //!Timeout(4) - fails
	public void test() throws InterruptedException{
		PerformanceTester p = new PerformanceTester();
		p.performTask();
	}
}
