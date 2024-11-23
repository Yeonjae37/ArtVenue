package com.database.artvenue.web.dto.reservation;

import com.database.artvenue.domain.enums.EventType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservationRequestDTO {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class createReservationDTO {
        private Long cafeId;
        private LocalDate eventDate;
        private LocalTime startTime;
        private LocalTime endTime;
        private EventType eventType;
        private String note;
    }
}
