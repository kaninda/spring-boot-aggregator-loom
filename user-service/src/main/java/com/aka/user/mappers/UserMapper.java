package com.aka.user.mappers;

import com.aka.user.dto.UserDto;
import com.aka.user.models.User;
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
