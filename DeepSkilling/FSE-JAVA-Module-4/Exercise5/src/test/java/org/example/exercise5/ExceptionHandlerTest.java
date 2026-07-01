package org.example.exercise5;

import org.example.exercise5.Service.UserService;
import org.example.exercise5.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.NoSuchElementException;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
public class ExceptionHandlerTest {
    @Autowired
    MockMvc mockMvc;
    @MockitoBean
    UserService userService;
    @Test
    void testExceptionHandler() throws  Exception{
        when(userService.getUserById(1L))
                .thenThrow(new NoSuchElementException());
        mockMvc.perform(get("/users/1"))
                .andExpect(status().isNotFound())
                .andExpect((ResultMatcher) content().string("User Not Found"));

    }
}
