package com.cognizant.simplegateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SimpleApiGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(SimpleApiGatewayApplication.class, args);
    }
}
