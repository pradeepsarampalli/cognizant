package com.cognizant.jwtauth.controller;

import com.cognizant.jwtauth.security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Exercise 3: Demo login endpoint. In a real application, this would validate
 * credentials against a user store (e.g. via UserDetailsService + PasswordEncoder)
 * before issuing a token.
 */
@RestController
public class AuthController {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/auth/login")
    public Map<String, String> login(@RequestBody LoginRequest request) {
        // NOTE: replace this with real credential validation.
        String token = jwtTokenProvider.createToken(request.username());
        return Map.of("token", token);
    }

    public record LoginRequest(String username, String password) {}
}
