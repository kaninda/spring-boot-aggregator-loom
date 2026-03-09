package com.aka.aggregator.service;

import com.aka.aggregator.dto.ProfileResponse;

import java.util.concurrent.ExecutionException;

public interface ProfileAggregationService {

    ProfileResponse buildProfile (Long userId) throws ExecutionException, InterruptedException;

}
