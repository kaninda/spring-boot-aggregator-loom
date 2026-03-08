package com.example.aggregator.service.impl;

import com.example.aggregator.controllers.UserController;
import com.example.aggregator.models.Loyalty;
import com.example.aggregator.repositories.LoyaltyRepository;
import com.example.aggregator.service.LoyaltyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class LoyaltyServiceImpl implements LoyaltyService {

    private final LoyaltyRepository loyaltyRepository;
    private static final Logger logger =  LoggerFactory.getLogger(LoyaltyServiceImpl.class);

    public LoyaltyServiceImpl(LoyaltyRepository loyaltyRepository) {
        this.loyaltyRepository = loyaltyRepository;
    }

    @Override
    public Loyalty fetchLoyalty(Long userId) {
        logger.info("Fetching loyalty for user {}", userId);
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return loyaltyRepository.findByUserId(userId);
    }
}
