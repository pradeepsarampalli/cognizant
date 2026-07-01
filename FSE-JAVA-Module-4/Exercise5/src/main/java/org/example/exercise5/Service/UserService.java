package org.example.exercise5.Service;

import org.example.exercise5.entity.User;
import org.example.exercise5.repository.UserRepository;
import org.hibernate.annotations.Audited;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User getUserById(Long id){
        return userRepository.findById(id).orElseThrow(NoSuchFieldError::new);
    }
    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
