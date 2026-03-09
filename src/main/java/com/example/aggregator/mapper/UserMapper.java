package com.aka.aggregator.mapper;

import com.aka.aggregator.dto.UserDto;
import com.aka.aggregator.models.User;
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
