package com.aka.loyalty.services.impl;

import com.aka.loyalty.models.Loyalty;
import com.aka.loyalty.repositories.LoyaltyRepository;
import com.aka.loyalty.services.LoyaltyService;
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
