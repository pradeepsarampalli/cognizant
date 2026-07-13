package com.cognizant.oauth2login.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {

    /**
     * Exercise 1: Displays the authenticated user's information after a
     * successful OAuth2/OIDC login.
     */
    @GetMapping("/user")
    public Map<String, Object> user(@AuthenticationPrincipal OAuth2User principal) {
        if (principal == null) {
            return Map.of("authenticated", false);
        }
        return Map.of(
                "authenticated", true,
                "name", principal.getAttribute("name") != null ? principal.getAttribute("name") : "unknown",
                "email", principal.getAttribute("email") != null ? principal.getAttribute("email") : "unknown",
                "attributes", principal.getAttributes()
        );
    }

    @GetMapping("/")
    public String home() {
        return "Welcome! Visit /oauth2/authorization/google to log in, then check /user.";
    }
}
