package com.cb.utils;

import com.cb.dto.UserDto;
import com.cb.model.User;

public class UserUtils {
    public static User toUser(UserDto userDto) {
        return new User(userDto.getFirstName(), userDto.getLastName());
    }

    public static UserDto toDto(User user) {
        return new UserDto(user.getFirstName(), user.getLastName());
    }
}
