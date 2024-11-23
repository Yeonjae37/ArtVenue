package com.database.artvenue.domain;
import com.database.artvenue.domain.enums.StatusType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private java.sql.Date reservationDate; //예약한 날짜

    @OneToOne(mappedBy = "reservation", cascade = CascadeType.ALL)
    private Event event;

    @Enumerated(EnumType.STRING)
    private StatusType status; //예약 상태

    private Double totalFee; //렌탈비 + 수수료

    @OneToOne(mappedBy = "reservation", cascade = CascadeType.ALL)
    private Payment payment;

    public void updateStatus(StatusType status) {
        this.status = status;
    }
}