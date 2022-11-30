package com.projectincremental.controllers;

import com.projectincremental.dtos.UserDto;
import com.projectincremental.dtos.mappers.UserMapper;
import com.projectincremental.entities.User;
import com.projectincremental.services.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

@RestController
@RequestMapping("")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String publicPage(@RequestBody UserDto userDto) {
        logger.info("Accessing /register");
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        User user = userMapper.toEntity(userDto);
        user.setRoles("ROLE_USER");
        userService.createUser(user);
        return "Hello World!";
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/private")
    public String privatePage(Authentication authentication) {
        logger.info("Accessing private");
        return "Welcome to this very private page, ~[" + getName(authentication) + "]~! 🥳🎉🍾";
    }

    private String getName(Authentication authentication) {
        return Optional.of(authentication.getName()).orElseGet(authentication::getName);
    }
}
