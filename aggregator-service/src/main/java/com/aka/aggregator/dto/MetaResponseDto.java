package com.aka.aggregator.dto;

import java.util.List;

public record MetaResponseDto(
        long durationMs,
        boolean partial,
        List<String> errors
) {
}
