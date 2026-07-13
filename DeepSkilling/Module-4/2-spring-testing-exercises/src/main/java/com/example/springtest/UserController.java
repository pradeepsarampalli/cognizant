package com.example.springtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.saveUser(user));
    }

    // Used by Exercise 8 (controller exception handling)
    @GetMapping("/strict/{id}")
    public ResponseEntity<User> getUserStrict(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserByIdOrThrow(id));
    }
}
