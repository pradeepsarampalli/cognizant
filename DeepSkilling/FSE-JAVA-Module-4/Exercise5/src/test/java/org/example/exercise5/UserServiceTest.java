package org.example.exercise5;

import org.example.exercise5.Service.UserService;
import org.example.exercise5.entity.User;
import org.example.exercise5.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    UserRepository userRepository;
    @InjectMocks
    UserService userService;
    @Test
    void testGetUserById(){
        User user = new User(1L,"Umesh");

        when(userRepository.findById(1L))
                .thenReturn(Optional.of(user));
        User user1 = userService.getUserById(1L);
        assertEquals("Umesh",user1.getName());
        assertEquals(1L,user1.getId());

    }

}
