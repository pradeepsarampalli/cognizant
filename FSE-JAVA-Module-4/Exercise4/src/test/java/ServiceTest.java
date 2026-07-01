import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServiceTest {
    @Test
    void testServiceWithMockRepository(){
        Repository repository = mock(Repository.class);
        when(repository.getData()).thenReturn("Mock Data");
        Service service = new Service(repository);
        assertEquals("Processed Mock Data",service.processData());
    }
    @Test
    void testMultipleReturns() {

        Repository repository = mock(Repository.class);

        when(repository.getData())
                .thenReturn("First Mock Data")
                .thenReturn("Second Mock Data");

        Service service = new Service(repository);

        assertEquals(
                "Processed First Mock Data",
                service.processData());

        assertEquals(
                "Processed Second Mock Data",
                service.processData());

    }

}


//// 1. Create Mock
//Dependency dependency = mock(Dependency.class);
//
//// 2. Stub
//when(dependency.method())
//        .thenReturn(value);
//
//// 3. Inject
//Service service = new Service(dependency);
//
//// 4. Execute
//String result = service.method();
//
//// 5. Assert / Verify
//assertEquals(...);
//verify(...);
