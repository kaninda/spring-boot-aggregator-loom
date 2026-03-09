package com.aka.order.dto;

import jakarta.persistence.Column;

public record OrderDto(
        double amounts,
        String currency,
        Long userId
) {
}
