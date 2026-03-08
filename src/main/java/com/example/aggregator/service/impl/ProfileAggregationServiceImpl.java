package com.example.aggregator.service.impl;

import com.example.aggregator.dto.*;
import com.example.aggregator.exception.ResourceNotFoundException;
import com.example.aggregator.models.Loyalty;
import com.example.aggregator.models.User;
import com.example.aggregator.repositories.UserRepository;
import com.example.aggregator.service.ProfileAggregationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.*;

@Service
public class ProfileAggregationServiceImpl implements ProfileAggregationService {

    private static final Logger logger = LoggerFactory.getLogger(ProfileAggregationServiceImpl.class);
    private static final String BASE_URL = "http://localhost:8080/api/v1/";

    private final RestClient restClient;

    public ProfileAggregationServiceImpl(RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public ProfileResponse buildProfile(Long userId) {
        long start = System.currentTimeMillis();
        UserDto user = restClient.get().uri(BASE_URL + "users/" + userId).retrieve().body(UserDto.class);
        LoyaltyDto loyalty = restClient.get().uri(BASE_URL + "loyalties/" + userId).retrieve().body(LoyaltyDto.class);
        List<OrderDto> orders = List.of(
                Objects.requireNonNull(
                        restClient.get().uri(BASE_URL + "orders/" + userId).retrieve().body(OrderDto[].class)
                )
        );
        long duration = System.currentTimeMillis() - start;
        MetaResponseDto meta = new MetaResponseDto(
                duration,
                false,
                new ArrayList<>()
        );
        logger.info("Profile built in {} ms", duration);
        return new ProfileResponse(
                user,
                orders,
                loyalty,
                meta
        );
    }
}
