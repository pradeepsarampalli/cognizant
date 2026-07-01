import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTests {
    @Test
    @Order(3)
    void testOne(){
        System.out.println("Test 1");
    } @Test
    @Order(2)
    void testTwo(){
        System.out.println("Test 2");
    } @Test
    @Order(1)
    void testThree(){
        System.out.println("Test 3");
    }
}
