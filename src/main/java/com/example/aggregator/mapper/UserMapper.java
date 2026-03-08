package com.example.aggregator.mapper;

import com.example.aggregator.dto.UserDto;
import com.example.aggregator.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDto toDto(User user) {
        return new UserDto(
                user.getName(),
                user.getEmail()
        );
    }
}
