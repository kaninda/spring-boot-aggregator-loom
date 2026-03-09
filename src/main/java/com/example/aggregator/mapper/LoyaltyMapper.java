package com.aka.aggregator.mapper;

import com.aka.aggregator.dto.LoyaltyDto;
import com.aka.aggregator.models.Loyalty;
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

