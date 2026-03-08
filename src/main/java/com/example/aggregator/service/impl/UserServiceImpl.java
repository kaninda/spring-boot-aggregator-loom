package com.example.aggregator.service.impl;

import com.example.aggregator.models.User;
import com.example.aggregator.repositories.UserRepository;
import com.example.aggregator.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private static final Logger logger =  LoggerFactory.getLogger(UserServiceImpl.class);

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User fetchUser(Long userId) {
        logger.info("Fetching user infos {}", userId);
        try {
            Thread.sleep(500); // simulation latence réseau
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return userRepository.findById(userId).orElseThrow(
                () -> new IllegalArgumentException( "User with id " + userId + " not found!")
        );
    }
}
