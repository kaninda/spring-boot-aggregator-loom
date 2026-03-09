package com.aka.loyalty.services;


import com.aka.loyalty.models.Loyalty;

public interface LoyaltyService {
    Loyalty fetchLoyalty (Long userId);
}
