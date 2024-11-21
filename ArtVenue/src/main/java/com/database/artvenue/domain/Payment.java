package com.database.artvenue.domain;
import jakarta.persistence.*;
import lombok.*;

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

    @Column(nullable = false)
    private java.sql.Date paymentDate;

    private String paymentMethod;

    private String status;
}