package com.aka.aggregator.dto;

import java.util.List;

public record ProfileResponse (
        UserDto user,
        List<OrderDto> orders,
        LoyaltyDto loyalty,
        MetaResponseDto meta
) {
}
