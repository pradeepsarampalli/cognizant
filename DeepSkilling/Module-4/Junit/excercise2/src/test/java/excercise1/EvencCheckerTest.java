package excercise1;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import excercise1.EvenChecker;

public class EvencCheckerTest {
	EvenChecker checker;

	@ParameterizedTest
	@ValueSource(ints= {2,4,6,8,10})
	public void test(int number) {
		checker = new EvenChecker();
		Assertions.assertTrue(checker.isEven(number));
	}
	
}
