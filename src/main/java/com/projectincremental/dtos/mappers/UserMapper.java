package com.projectincremental.dtos.mappers;

import com.projectincremental.dtos.UserDto;
import com.projectincremental.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setMail(userDto.getMail());
        user.setPassword(userDto.getPassword());
        return user;
    }
}
