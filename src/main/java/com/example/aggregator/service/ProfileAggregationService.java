package com.example.aggregator.service;

import com.example.aggregator.dto.ProfileResponse;

import java.util.concurrent.ExecutionException;

public interface ProfileAggregationService {

    ProfileResponse buildProfile (Long userId) throws ExecutionException, InterruptedException;

}
