package com.cognizant.resourceserver.controller;

import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SecureController {

    @GetMapping("/secure")
    public Map<String, Object> secure(@AuthenticationPrincipal Jwt jwt) {
        return Map.of(
                "message", "This is a secure endpoint",
                "subject", jwt.getSubject(),
                "claims", jwt.getClaims()
        );
    }
}
