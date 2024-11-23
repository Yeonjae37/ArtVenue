package com.database.artvenue.request;

import com.database.artvenue.domain.enums.UserType;
import jakarta.validation.constraints.NotEmpty;

public record UserRequest(
        @NotEmpty(message = "이름이 비어")
        String name,

        @NotEmpty(message = "")
        String password,

        @NotEmpty(message = "")
        String contactInfo,

        @NotEmpty(message = "")
        UserType userType
) {
}