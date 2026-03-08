package com.example.aggregator.dto;

import jakarta.persistence.Column;

public record OrderDto(
        double amounts,
        String currency,
        Long userId
) {
}
