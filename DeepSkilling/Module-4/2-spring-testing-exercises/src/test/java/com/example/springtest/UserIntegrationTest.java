package com.example.springtest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Exercise 4: Integration Test with Spring Boot
 * Full flow: controller -> service -> repository -> (in-memory) database.
 * Requires an H2 in-memory DB on the test classpath (see pom.xml).
 */
@SpringBootTest
@AutoConfigureMockMvc
public class UserIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFullFlow_createAndFetchUser() throws Exception {
        // Create a user via the real service/repository (backed by H2)
        User saved = userRepository.save(new User(null, "Charan"));

        mockMvc.perform(get("/users/" + saved.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Charan"));
    }

    @Test
    public void testFullFlow_createViaPostEndpoint() throws Exception {
        String requestBody = "{\"name\":\"Shresta\"}";

        mockMvc.perform(post("/users")
                        .contentType("application/json")
                        .content(requestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Shresta"))
                .andExpect(jsonPath("$.id").exists());
    }
}
