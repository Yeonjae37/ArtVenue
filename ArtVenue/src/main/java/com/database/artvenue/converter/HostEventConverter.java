package com.database.artvenue.converter;

import com.database.artvenue.domain.Event;
import com.database.artvenue.domain.User;
import com.database.artvenue.domain.mapping.HostEvent;
import com.database.artvenue.web.dto.reservation.ReservationRequestDTO;

public class HostEventConverter {
    public static HostEvent toEntity(User user, Event event, ReservationRequestDTO.createReservationDTO request) {
        return HostEvent.builder()
                .host(user)                        // 주최자 정보
                .event(event)                      // 이벤트 정보
                .note(request.getNote())           // 주최자 메모
                .build();
    }
}
