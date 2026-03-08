package com.example.aggregator.service.impl;

import com.example.aggregator.models.Order;
import com.example.aggregator.repositories.OrderRepository;
import com.example.aggregator.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private static final Logger logger =  LoggerFactory.getLogger(OrderServiceImpl.class);

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> fetchOrders(Long userId) {
        logger.info("Fetching orders for user {}", userId);
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return orderRepository.findByUserId(userId);
    }
}
