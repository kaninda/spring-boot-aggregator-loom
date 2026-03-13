package com.aka.aggregator.dto;

public record OrderDto(
        double amounts,
        String currency,
        Long userId
) {
}
