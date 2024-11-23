package com.database.artvenue.repository;

import com.database.artvenue.domain.Payment;
import com.database.artvenue.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
    Optional<Payment> findByReservation(Reservation reservation);
}
