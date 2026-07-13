package exercise2;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({AddTest.class,SubtractTest.class})
public class AllTests {
	
}
