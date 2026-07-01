import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestEvenChecker {
    EvenChecker evenChecker = new EvenChecker();
    @ValueSource(ints = {2,14,6,8})
    @ParameterizedTest
    void testEven(int number){
        assertTrue(evenChecker.isEven(number));
    }

}
