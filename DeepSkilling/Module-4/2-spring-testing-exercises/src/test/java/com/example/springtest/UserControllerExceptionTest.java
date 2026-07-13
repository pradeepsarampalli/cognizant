package com.example.springtest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.NoSuchElementException;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Exercise 8: Test Controller Exception Handling
 * Verifies that GlobalExceptionHandler correctly translates a NoSuchElementException
 * into a 404 response.
 */
@WebMvcTest(controllers = UserController.class)
// The @ControllerAdvice is picked up automatically by @WebMvcTest as long as it's
// in a package scanned by the test's component scan (same base package here).
public class UserControllerExceptionTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void testGetUserStrict_userNotFound_returns404() throws Exception {
        when(userService.getUserByIdOrThrow(404L))
                .thenThrow(new NoSuchElementException("User not found with id: 404"));

        mockMvc.perform(get("/users/strict/404"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("User not found"));
    }
}
