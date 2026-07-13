package com.example.mockdeps;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Exercise 2: Mocking a Repository in a Service Test
 *
 * Pure Mockito test - no Spring context is loaded at all, which makes this
 * the fastest kind of test. UserRepository is mocked directly and injected
 * into UserService via @InjectMocks.
 */
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testGetUserById_delegatesToRepository() {
        User user = new User(1L, "Pradeep");
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        User result = userService.getUserById(1L);

        assertEquals("Pradeep", result.getName());
        verify(userRepository).findById(1L);
    }

    @Test
    public void testGetUserById_notFound_returnsNull() {
        when(userRepository.findById(2L)).thenReturn(Optional.empty());

        User result = userService.getUserById(2L);

        assertNull(result);
    }
}
