package com.example.aggregator.service;

import com.example.aggregator.models.Loyalty;

public interface LoyaltyService {
    Loyalty fetchLoyalty (Long userId);
}
