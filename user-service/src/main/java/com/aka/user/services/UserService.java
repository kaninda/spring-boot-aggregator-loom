package com.aka.user.services;


import com.aka.user.models.User;

public interface UserService {
    User fetchUser (Long userId);
}
