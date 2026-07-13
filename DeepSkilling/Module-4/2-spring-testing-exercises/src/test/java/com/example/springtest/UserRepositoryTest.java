package com.example.springtest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Exercise 7: Test Custom Repository Query
 * @DataJpaTest spins up an in-memory (H2) database and only loads JPA-related beans.
 */
@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindByName() {
        userRepository.save(new User(null, "Pradeep"));
        userRepository.save(new User(null, "Pradeep"));
        userRepository.save(new User(null, "Charan"));

        List<User> results = userRepository.findByName("Pradeep");

        assertEquals(2, results.size());
        assertTrue(results.stream().allMatch(u -> u.getName().equals("Pradeep")));
    }

    @Test
    public void testFindByName_noMatches() {
        userRepository.save(new User(null, "Shresta"));

        List<User> results = userRepository.findByName("NonExistent");

        assertTrue(results.isEmpty());
    }
}
