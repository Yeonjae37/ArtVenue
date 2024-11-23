package com.database.artvenue.api.code.status;

import com.database.artvenue.api.code.BaseCode;
import com.database.artvenue.api.code.ReasonDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessStatus implements BaseCode {
    _OK(HttpStatus.OK, "2000", "Ok"),

    _GET_USER_OK(HttpStatus.OK, "2001", "유저 로그인이 완료되었습니다."),
    _POST_USER_OK(HttpStatus.OK, "2002", "유저 회원가입이 완료되었습니다."),

    _CAFE_OK(HttpStatus.OK, "2003", "카페 등록이 완료되었습니다."),

    ;


    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ReasonDto getReason() {
        return ReasonDto.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ReasonDto getReasonHttpStatus() {
        return ReasonDto.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build();
    }
}