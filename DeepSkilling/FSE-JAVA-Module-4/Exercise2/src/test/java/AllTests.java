import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        TestCalculator.class,
        TestEvenChecker.class
})
public class AllTests {

}
