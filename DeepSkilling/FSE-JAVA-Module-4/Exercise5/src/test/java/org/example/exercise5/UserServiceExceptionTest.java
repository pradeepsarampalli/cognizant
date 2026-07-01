package org.example.exercise5;

import org.example.exercise5.Service.UserService;
import org.example.exercise5.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class UserServiceExceptionTest {
    @Mock
    UserRepository userRepository;
    @InjectMocks
    UserService userService;
    @Test
    void testUserNotFound(){
        when(userRepository.findById(1L))
                .thenReturn(Optional.empty());
        assertThrows(NoSuchFieldError.class,()->userService.getUserById(1L));
    }
}
