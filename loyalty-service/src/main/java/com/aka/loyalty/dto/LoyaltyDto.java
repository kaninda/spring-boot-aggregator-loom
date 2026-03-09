package com.aka.loyalty.dto;

public record LoyaltyDto(
        Long userId,
        String tier,
        Integer points
) {
}
