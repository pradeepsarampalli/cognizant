package com.example.mockito;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

/**
 * Full solutions for the Mockito Hands-On Exercises (1-7).
 */
public class MyServiceTest {

    // ---------------------------------------------------------------
    // Exercise 1: Mocking and Stubbing
    // ---------------------------------------------------------------
    @Test
    public void testExternalApi() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Mock Data");

        MyService service = new MyService(mockApi);
        String result = service.fetchData();

        assertEquals("Mock Data", result);
    }

    // ---------------------------------------------------------------
    // Exercise 2: Verifying Interactions
    // ---------------------------------------------------------------
    @Test
    public void testVerifyInteraction() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        service.fetchData();

        verify(mockApi).getData();
        verify(mockApi, times(1)).getData();
    }

    // ---------------------------------------------------------------
    // Exercise 3: Argument Matching
    // ---------------------------------------------------------------
    @Test
    public void testArgumentMatching() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getDataById(anyString())).thenReturn("Matched Data");

        MyService service = new MyService(mockApi);
        String result = service.fetchDataById("user-123");

        assertEquals("Matched Data", result);

        // Verify called with a specific argument
        verify(mockApi).getDataById(eq("user-123"));

        // Verify called with any string argument
        verify(mockApi).getDataById(anyString());

        // Verify called with an argument matching a custom condition
        verify(mockApi).getDataById(argThat(id -> id.startsWith("user-")));
    }

    // ---------------------------------------------------------------
    // Exercise 4: Handling Void Methods
    // ---------------------------------------------------------------
    @Test
    public void testVoidMethod() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // doNothing() is the default for void methods, but can be stated explicitly
        doNothing().when(mockApi).performAction(anyString());

        MyService service = new MyService(mockApi);
        service.triggerAction("SYNC");

        verify(mockApi).performAction("SYNC");
    }

    // ---------------------------------------------------------------
    // Exercise 5: Mocking and Stubbing with Multiple Returns
    // ---------------------------------------------------------------
    @Test
    public void testMultipleReturns() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        // Different value on each consecutive call
        when(mockApi.getData())
                .thenReturn("First Call")
                .thenReturn("Second Call")
                .thenReturn("Third Call");

        MyService service = new MyService(mockApi);

        assertEquals("First Call", service.fetchData());
        assertEquals("Second Call", service.fetchData());
        assertEquals("Third Call", service.fetchData());
        // Mockito keeps returning the last stubbed value after the sequence is exhausted
        assertEquals("Third Call", service.fetchData());
    }

    // ---------------------------------------------------------------
    // Exercise 6: Verifying Interaction Order
    // ---------------------------------------------------------------
    @Test
    public void testVerifyInteractionOrder() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);

        service.fetchData();
        service.triggerAction("LOG");
        service.fetchDataById("42");

        InOrder inOrder = inOrder(mockApi);
        inOrder.verify(mockApi).getData();
        inOrder.verify(mockApi).performAction("LOG");
        inOrder.verify(mockApi).getDataById("42");
    }

    // ---------------------------------------------------------------
    // Exercise 7: Handling Void Methods with Exceptions
    // ---------------------------------------------------------------
    @Test
    public void testVoidMethodThrowsException() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);

        doThrow(new IllegalStateException("External system unavailable"))
                .when(mockApi).performAction("FAIL");

        MyService service = new MyService(mockApi);

        IllegalStateException thrown = assertThrows(
                IllegalStateException.class,
                () -> service.triggerAction("FAIL")
        );

        assertEquals("External system unavailable", thrown.getMessage());
        verify(mockApi).performAction("FAIL");
    }
}
