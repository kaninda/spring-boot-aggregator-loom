package com.aka.aggregator.service;

import com.aka.aggregator.dto.ProfileResponse;
import com.aka.aggregator.models.Order;

import java.util.List;

public interface OrderService {
    List<Order> fetchOrders (Long userId);
}
