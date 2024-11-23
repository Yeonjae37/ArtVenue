package com.database.artvenue.converter;

import com.database.artvenue.domain.*;
import com.database.artvenue.domain.enums.PaymentStatusType;
import com.database.artvenue.domain.enums.PaymentType;
import com.database.artvenue.web.dto.payment.PaymentRequestDTO;

import java.sql.Date;

public class PaymentConverter {

    public static Payment toEntity(Reservation reservation) {
        return Payment.builder()
                .reservation(reservation)                  // 예약과 매핑
                .amount(reservation.getTotalFee())         // 예약 금액 사용
                .status(PaymentStatusType.PENDING)         // 초기 상태를 PENDING으로 설정
                .build();
    }
}
