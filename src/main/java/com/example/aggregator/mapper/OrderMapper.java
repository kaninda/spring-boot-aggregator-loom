package com.example.aggregator.mapper;

import com.example.aggregator.dto.OrderDto;
import com.example.aggregator.models.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderMapper {
    public OrderDto toDto(Order order) {
        return new OrderDto(
           order.getAmounts(),
           order.getCurrency(),
           order.getUserId()
        );
    }

    public List<OrderDto> toDto(List<Order> orders) {
        List<OrderDto> dtos = new ArrayList<>();
        orders.forEach(
               order -> dtos.add(toDto(order))
        );
        return dtos;
    }
}
