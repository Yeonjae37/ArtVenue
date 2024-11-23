package com.database.artvenue.service;

import com.database.artvenue.api.code.status.ErrorStatus;
import com.database.artvenue.api.exception.handler.UserHandler;
import com.database.artvenue.domain.*;
import com.database.artvenue.domain.enums.StatusType;
import com.database.artvenue.repository.PaymentRepository;
import com.database.artvenue.repository.ReservationRepository;
import com.database.artvenue.web.dto.payment.PaymentRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.database.artvenue.domain.enums.PaymentStatusType;

@Service
public class PaymentService {

    private final ReservationRepository reservationRepository;
    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(ReservationRepository reservationRepository, PaymentRepository paymentRepository) {
        this.reservationRepository = reservationRepository;
        this.paymentRepository = paymentRepository;
    }


    public void makePayment(PaymentRequestDTO.CreatePaymentDTO request) {
        Reservation reservation = reservationRepository.findById(request.getReservationId())
                .orElseThrow(() -> new UserHandler(ErrorStatus._RESERVATION_NOT_FOUND));

        Payment payment = paymentRepository.findByReservation(reservation)
                .orElseThrow(() -> new UserHandler(ErrorStatus._PAYMENT_NOT_FOUND));

        payment.updatePaymentStatus(PaymentStatusType.COMPLETED, request.getPaymentMethod());
        paymentRepository.save(payment);

        reservation.updateStatus(StatusType.COMPLETED);
        reservationRepository.save(reservation);
    }
}
