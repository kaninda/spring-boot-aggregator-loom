package com.aka.loyalty.mapper;

import com.aka.loyalty.dto.LoyaltyDto;
import com.aka.loyalty.models.Loyalty;
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

