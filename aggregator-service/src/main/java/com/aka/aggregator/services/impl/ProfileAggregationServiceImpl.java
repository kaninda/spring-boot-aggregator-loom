package com.aka.aggregator.services.impl;

import com.aka.aggregator.dto.*;
import com.aka.aggregator.services.ProfileAggregationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class ProfileAggregationServiceImpl implements ProfileAggregationService {

    private static final Logger logger = LoggerFactory.getLogger(ProfileAggregationServiceImpl.class);
    private static final String BASE_URL = "http://localhost:8080/api/v1/";

    private final RestClient restClient;

    public ProfileAggregationServiceImpl(RestClient restClient) {
        this.restClient = restClient;
    }

    @Override
    public ProfileResponse buildProfile(Long userId) throws ExecutionException, InterruptedException {
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {

            long start = System.currentTimeMillis();
            CompletableFuture<UserDto> userDtoCompletableFuture = CompletableFuture.supplyAsync(
                    () -> restClient.get().uri(
                            BASE_URL + "users/" + userId
                    ).retrieve().body(UserDto.class),executor
            );

            CompletableFuture<LoyaltyDto> loyaltyDtoCompletableFuture = CompletableFuture.supplyAsync(
                    () -> restClient.get().uri(
                            BASE_URL + "loyalties/" + userId).retrieve().body(LoyaltyDto.class),executor
            );
            CompletableFuture<List<OrderDto>> ordersFuture = CompletableFuture.supplyAsync(
                    () -> Arrays.asList(
                            Objects.requireNonNull(
                                    restClient.get()
                                            .uri(BASE_URL + "orders/" + userId)
                                            .retrieve()
                                            .body(OrderDto[].class)
                            )
                    ),
                    executor
            );
            UserDto user = userDtoCompletableFuture.get();
            LoyaltyDto loyalty = loyaltyDtoCompletableFuture.get();
            List<OrderDto> orders = ordersFuture.get();

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
}
