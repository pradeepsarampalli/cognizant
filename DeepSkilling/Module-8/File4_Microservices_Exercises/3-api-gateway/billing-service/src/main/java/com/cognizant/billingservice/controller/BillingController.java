package com.cognizant.billingservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class BillingController {

    @GetMapping("/api/v1/billing/{customerId}")
    public Map<String, Object> getBilling(@PathVariable String customerId) {
        return Map.of(
                "customerId", customerId,
                "outstandingBalance", 1499.00,
                "currency", "INR"
        );
    }
}
