package com.example.aggregator.service;

import com.example.aggregator.dto.ProfileResponse;
import com.example.aggregator.models.Order;

import java.util.List;

public interface OrderService {
    List<Order> fetchOrders (Long userId);
}
