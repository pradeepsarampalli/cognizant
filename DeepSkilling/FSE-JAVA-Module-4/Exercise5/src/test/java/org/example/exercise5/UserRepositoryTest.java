package org.example.exercise5;

import org.example.exercise5.entity.User;
import org.example.exercise5.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;
    @Test
    void testFindByName(){
        User user = new User(1L,"Umesh");
        userRepository.save(user);
        List<User> users = userRepository.findByName("Umesh");
        assertEquals("Umesh",users.get(0).getName());
    }
}
