package com.aka.aggregator.service;

import com.aka.aggregator.models.User;

public interface UserService {
    User fetchUser (Long userId);
}
