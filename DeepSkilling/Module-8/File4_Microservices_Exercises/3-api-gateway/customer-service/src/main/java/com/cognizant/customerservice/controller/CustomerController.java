package com.cognizant.customerservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CustomerController {

    @GetMapping("/api/v1/customers/{id}")
    public Map<String, Object> getCustomer(@PathVariable String id) {
        return Map.of(
                "id", id,
                "name", "Sample Customer " + id,
                "tier", "gold"
        );
    }
}
