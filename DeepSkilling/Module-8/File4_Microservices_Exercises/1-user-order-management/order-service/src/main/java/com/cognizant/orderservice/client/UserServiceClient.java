package com.cognizant.orderservice.client;

import com.cognizant.orderservice.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * OpenFeign declarative client used by order-service to call user-service.
 * The 'url' property points at user-service directly; replace with Eureka
 * service discovery (name = "user-service", drop the url attribute, add
 * @LoadBalanced) once both services are registered with a discovery server.
 */
@FeignClient(name = "user-service", url = "${user-service.url}")
public interface UserServiceClient {

    @GetMapping("/users/{id}")
    UserDto getUserById(@PathVariable("id") Long id);
}
