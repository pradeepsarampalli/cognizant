package org.example.exercise5;

import org.example.exercise5.Service.UserService;
import org.example.exercise5.controller.UserController;
import org.example.exercise5.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
public class UserControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    UserService userService;
    @Test
    void testGetUser() throws Exception {
        User user = new User(1L, "Umesh");
        when(userService.getUserById(1L))
                .thenReturn(user);
        mockMvc.perform(get("/users/1"))
                .andExpect(status().isOk())

        .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Umesh"));
    }
}
