package com.database.artvenue.converter;

import com.database.artvenue.domain.Cafe;
import com.database.artvenue.domain.Event;
import com.database.artvenue.domain.Reservation;
import com.database.artvenue.web.dto.reservation.ReservationRequestDTO;

public class EventConverter {
    public static Event toEntity(ReservationRequestDTO.createReservationDTO request, Cafe cafe, Reservation reservation) {
        return Event.builder()
                .cafe(cafe)
                .reservation(reservation)
                .eventType(request.getEventType())
                .eventDate(java.sql.Date.valueOf(request.getEventDate()))
                .startTime(java.sql.Time.valueOf(request.getStartTime()))
                .endTime(java.sql.Time.valueOf(request.getEndTime()))
                .build();
    }
}
