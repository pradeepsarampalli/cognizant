package com.cognizant.orderservice.dto;

import com.cognizant.orderservice.model.Order;

/**
 * Combines order data with the user data fetched from user-service,
 * demonstrating cross-service communication.
 */
public class OrderResponse {
    private Order order;
    private UserDto user;

    public OrderResponse(Order order, UserDto user) {
        this.order = order;
        this.user = user;
    }

    public Order getOrder() { return order; }
    public UserDto getUser() { return user; }
}
