package com.example.springtest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

/**
 * Exercise 6: Test Service Exception Handling
 */
@ExtendWith(MockitoExtension.class)
public class UserServiceExceptionTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void testGetUserByIdOrThrow_missingUserThrowsException() {
        when(userRepository.findById(404L)).thenReturn(Optional.empty());

        NoSuchElementException thrown = assertThrows(
                NoSuchElementException.class,
                () -> userService.getUserByIdOrThrow(404L)
        );

        assertEquals("User not found with id: 404", thrown.getMessage());
    }

    @Test
    public void testGetUserById_missingUserReturnsNull() {
        when(userRepository.findById(404L)).thenReturn(Optional.empty());

        User result = userService.getUserById(404L);

        assertNull(result);
    }
}
