package com.example.aggregator.controllers;

import com.example.aggregator.dto.LoyaltyDto;
import com.example.aggregator.mapper.LoyaltyMapper;
import com.example.aggregator.models.Loyalty;
import com.example.aggregator.models.Order;
import com.example.aggregator.service.LoyaltyService;
import com.example.aggregator.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(
        name = "LoyaltyController",
        value = "/api/v1/loyalties",
        produces = MediaType.APPLICATION_JSON_VALUE
)
@RestController
public class LoyaltyController {

    private final LoyaltyService loyaltyService;
    private final LoyaltyMapper loyaltyMapper;
    private static final Logger logger =  LoggerFactory.getLogger(LoyaltyController.class);

    public LoyaltyController(LoyaltyService loyaltyService, LoyaltyMapper loyaltyMapper) {
        this.loyaltyService = loyaltyService;
        this.loyaltyMapper = loyaltyMapper;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<LoyaltyDto> getUser(@PathVariable Long userId) {
        logger.info("Thread current: {}", Thread.currentThread());
        Loyalty loyalty = loyaltyService.fetchLoyalty(userId);
        return ResponseEntity.status(HttpStatus.OK).body(loyaltyMapper.toDto(loyalty));
    }
}
