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
    _GET_LIST_CAFE_OK(HttpStatus.OK, "2004", "카페 전체 리스트 조회가 완료되었습니다."),
    _GET_CAFE_OK(HttpStatus.OK, "2005", "카페 상세 조회가 완료되었습니다."),
    _GET_LIST_RESERVATION_OK(HttpStatus.OK, "2006", "예약 내역 전체 조회가 완료되었습니다."),

    _CREATE_RESERVATION_OK(HttpStatus.OK, "3001", "카페 예약이 완료되었습니다."),

    _PAYMENT_SUCCESS(HttpStatus.OK, "2008", "결제가 완료되었습니다.")
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