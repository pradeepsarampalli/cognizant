package com.cognizant.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayEdgeServicesApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayEdgeServicesApplication.class, args);
    }
}
