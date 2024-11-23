package com.database.artvenue.converter;

import com.database.artvenue.domain.User;
import com.database.artvenue.domain.enums.UserType;
import com.database.artvenue.web.dto.user.UserRequestDTO;

public class UserConverter {

    public static User toEntity(UserRequestDTO.SignUpDTO dto) {
        return User.builder()
                .name(dto.getName())
                .password(dto.getPassword())
                .contactInfo(dto.getContactInfo())
                .userType(UserType.valueOf(dto.getUserType().name()))
                .build();
    }
}