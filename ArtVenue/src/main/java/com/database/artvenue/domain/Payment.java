package com.database.artvenue.domain;
import com.database.artvenue.domain.enums.PaymentStatusType;
import com.database.artvenue.domain.enums.PaymentType;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;

    @OneToOne
    private Reservation reservation;

    @Column(nullable = false)
    private Double amount;

    private java.sql.Date paymentDate;

    @Enumerated(EnumType.STRING)
    private PaymentType paymentMethod;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatusType status;

    public void updatePaymentStatus(PaymentStatusType status, PaymentType paymentMethod) {
        if (this.status == PaymentStatusType.COMPLETED) {
            throw new IllegalStateException("Payment is already completed.");
        }
        this.status = status;
        this.paymentMethod = paymentMethod;
        this.paymentDate = new Date(System.currentTimeMillis()); // 결제 완료 시간
    }
}