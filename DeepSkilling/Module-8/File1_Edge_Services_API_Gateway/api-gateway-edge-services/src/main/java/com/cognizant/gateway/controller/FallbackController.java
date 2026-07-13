package com.cognizant.gateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Exercise 3: Fallback endpoint invoked by the CircuitBreaker gateway filter
 * whenever the downstream service is unavailable or times out.
 */
@RestController
public class FallbackController {

    @GetMapping("/fallback")
    public ResponseEntity<Map<String, Object>> fallback() {
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE)
                .body(Map.of(
                        "message", "Service is temporarily unavailable. Please try again later.",
                        "status", "fallback-triggered"
                ));
    }
}
