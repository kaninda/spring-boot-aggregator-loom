package com.aka.order.services;


import com.aka.order.models.Order;

import java.util.List;

public interface OrderService {
    List<Order> fetchOrders (Long userId);
}
