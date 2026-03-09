package com.aka.user.controllers;

import com.aka.user.dto.UserDto;
import com.aka.user.mappers.UserMapper;
import com.aka.user.models.User;
import com.aka.user.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(
        name = "UserController",
        value = "/api/v1/users",
        produces = MediaType.APPLICATION_JSON_VALUE
)

@RestController
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;
    private static final Logger logger =  LoggerFactory.getLogger(UserController.class);

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long userId) {
        logger.info("Thread current: {}", Thread.currentThread());
        User user = userService.fetchUser(userId);
        return ResponseEntity.status(HttpStatus.OK).body(
                userMapper.toDto(user));
    }
}
