import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ApiServiceTest {
    @Test
    void ApiServiceTestFun(){
        RestClient restClient = mock(RestClient.class);
        when(restClient.getResponse()).thenReturn("Rest api");
        ApiService apiService = new ApiService(restClient);
        assertEquals("Rest api",apiService.fetchData());

    }
}
