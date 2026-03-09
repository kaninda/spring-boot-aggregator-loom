package com.aka.order.mapper;

import com.aka.order.dto.OrderDto;
import com.aka.order.models.Order;
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
