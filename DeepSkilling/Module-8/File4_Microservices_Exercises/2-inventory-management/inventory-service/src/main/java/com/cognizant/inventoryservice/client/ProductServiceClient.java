package com.cognizant.inventoryservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Feign client that talks to product-service through Eureka service
 * discovery (note: no hardcoded host/port, unlike order-service in
 * Problem 1 - "name" alone is resolved via the Eureka registry).
 */
@FeignClient(name = "product-service")
public interface ProductServiceClient {

    @GetMapping("/products/{id}")
    Object getProduct(@PathVariable("id") Long id);
}
