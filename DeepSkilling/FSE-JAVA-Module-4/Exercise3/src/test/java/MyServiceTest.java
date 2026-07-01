import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MyServiceTest {
    @Test
void testApi(){
    ExternalApi mockapi = Mockito.mock(ExternalApi.class);
    when(mockapi.getData())
            .thenReturn("First")

            .thenReturn("Third");
    MyService myService = new MyService(mockapi);
    assertEquals("First",myService.fetchData());
//    assertEquals("Second",myService.fetchData());
    assertEquals("Third",myService.fetchData());
//    verify(mockapi,times(3)).getData();
}
}
