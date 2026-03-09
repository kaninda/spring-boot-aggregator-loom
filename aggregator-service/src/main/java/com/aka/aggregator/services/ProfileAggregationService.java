package com.aka.aggregator.services;

import com.aka.aggregator.dto.ProfileResponse;

import java.util.concurrent.ExecutionException;

public interface ProfileAggregationService {

    ProfileResponse buildProfile (Long userId) throws ExecutionException, InterruptedException;

}
