package com.example.aggregator.service;

import com.example.aggregator.dto.ProfileResponse;

public interface ProfileAggregationService {

    ProfileResponse buildProfile (Long userId);

}
