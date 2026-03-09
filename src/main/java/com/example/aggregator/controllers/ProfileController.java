package com.example.aggregator.controllers;

import com.example.aggregator.dto.ProfileResponse;
import com.example.aggregator.service.ProfileAggregationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;


@RequestMapping(
        name = "ProfileController",
        value = "/api/v1/profile",
        produces = MediaType.APPLICATION_JSON_VALUE
)
@RestController
public class ProfileController {

    private final ProfileAggregationService profileAggregationService;
    private static final Logger logger =  LoggerFactory.getLogger(ProfileController.class);

    public ProfileController(ProfileAggregationService profileAggregationService) {
        this.profileAggregationService = profileAggregationService;
    }
    @GetMapping("/{userId}")
    public ResponseEntity<ProfileResponse> getUser(@PathVariable  Long userId) throws ExecutionException, InterruptedException {
        logger.info("Thread current: {}", Thread.currentThread());
        ProfileResponse profileResponse = profileAggregationService.buildProfile(userId);
        return ResponseEntity.status(HttpStatus.OK).body(profileResponse);
    }
}
