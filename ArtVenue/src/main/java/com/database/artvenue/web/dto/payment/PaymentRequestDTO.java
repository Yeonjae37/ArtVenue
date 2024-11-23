package com.database.artvenue.web.dto.payment;

import com.database.artvenue.domain.enums.PaymentType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class PaymentRequestDTO {
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreatePaymentDTO {
        private Long reservationId;
        private PaymentType paymentMethod;
    }
}
