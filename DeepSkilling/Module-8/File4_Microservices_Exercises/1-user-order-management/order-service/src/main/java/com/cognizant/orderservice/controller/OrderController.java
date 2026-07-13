package com.cognizant.orderservice.controller;

import com.cognizant.orderservice.client.UserServiceClient;
import com.cognizant.orderservice.dto.OrderResponse;
import com.cognizant.orderservice.dto.UserDto;
import com.cognizant.orderservice.model.Order;
import com.cognizant.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserServiceClient userServiceClient;

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order saved = orderRepository.save(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    /**
     * Fetches the order, then calls user-service (via Feign) to enrich the
     * response with the placing user's details.
     */
    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrderWithUser(@PathVariable Long id) {
        return orderRepository.findById(id)
                .map(order -> {
                    UserDto user = userServiceClient.getUserById(order.getUserId());
                    return ResponseEntity.ok(new OrderResponse(order, user));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/user/{userId}")
    public List<Order> getOrdersByUser(@PathVariable Long userId) {
        return orderRepository.findByUserId(userId);
    }
}
