package com.aka.aggregator.service;

import com.aka.aggregator.models.Loyalty;

public interface LoyaltyService {
    Loyalty fetchLoyalty (Long userId);
}
