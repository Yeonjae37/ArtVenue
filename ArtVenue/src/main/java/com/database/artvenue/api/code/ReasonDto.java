package com.database.artvenue.api.code;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReasonDto {
    private String code;
    private String message;
    private Boolean isSuccess;
    private HttpStatus httpStatus;
}