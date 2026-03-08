package com.example.aggregator.service;

import com.example.aggregator.models.User;

public interface UserService {
    User fetchUser (Long userId);
}
