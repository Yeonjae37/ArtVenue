package com.database.artvenue.web.dto.user;

import com.database.artvenue.domain.enums.UserType;
import lombok.Getter;

public class UserRequestDTO {
    @Getter
    public static class SignUpDTO {
        private String name;
        private String password;
        private String contactInfo;
        private UserType userType;
    }

    @Getter
    public static class LoginDTO {
        private final String name;
        private final String password;

        public LoginDTO(String name, String password) {
            this.name = name;
            this.password = password;
        }
    }
}

