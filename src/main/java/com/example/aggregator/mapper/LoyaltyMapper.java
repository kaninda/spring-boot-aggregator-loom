package com.example.aggregator.mapper;

import com.example.aggregator.dto.LoyaltyDto;
import com.example.aggregator.models.Loyalty;
import org.springframework.stereotype.Component;

@Component
public class LoyaltyMapper {

    public LoyaltyDto toDto(Loyalty loyalty) {
        return new LoyaltyDto(
                loyalty.getUserId(),
                loyalty.getTier(),
                loyalty.getPoints()
        );
    }
}

