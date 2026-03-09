package com.aka.aggregator.controllers;

import com.aka.aggregator.dto.OrderDto;
import com.aka.aggregator.mapper.OrderMapper;
import com.aka.aggregator.models.Order;
import com.aka.aggregator.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping(
        name = "OrderController",
        value = "/api/v1/orders",
        produces = MediaType.APPLICATION_JSON_VALUE
)
@RestController
public class OrderController {

    private final OrderService orderService;
    private final OrderMapper orderMapper;
    private static final Logger logger =  LoggerFactory.getLogger(OrderController.class);

    public OrderController(OrderService orderService, OrderMapper orderMapper) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<OrderDto>> getOrder(@PathVariable Long userId) {
        logger.info("Thread current: {}", Thread.currentThread());
        List<Order> orders = orderService.fetchOrders(userId);
        return ResponseEntity.status(HttpStatus.OK).body(orderMapper.toDto(orders));
    }
}
