package com.database.artvenue.converter;

import com.database.artvenue.domain.Cafe;
import com.database.artvenue.domain.Reservation;
import com.database.artvenue.domain.enums.StatusType;
import com.database.artvenue.web.dto.reservation.ReservationRequestDTO;
import com.database.artvenue.web.dto.reservation.ReservationResponseDTO;
import org.springframework.data.domain.Page;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ReservationConverter {
    public static Reservation toEntity(ReservationRequestDTO.createReservationDTO request, Cafe cafe) {
        return Reservation.builder()
                .reservationDate(Date.valueOf(LocalDate.now()))
                .status(StatusType.PENDING)
                .totalFee(cafe.getRentalFee() + 25000)
                .build();
    }

    public static ReservationResponseDTO.ReservationPreviewDTO toPreviewDTO(Reservation reservation) {
        return ReservationResponseDTO.ReservationPreviewDTO.builder()
                .reservationId(reservation.getId().longValue())  // 예약 ID
                .reservationDate(reservation.getReservationDate()) // 예약 날짜
                .statusType(reservation.getStatus())            // 예약 상태
                .name(reservation.getEvent().getCafe().getName()) // 카페 이름
                .build();
    }

    public static ReservationResponseDTO.ReservationPreviewListDTO toPreviewListDTO(
            Page<Reservation> reservations) {
        List<ReservationResponseDTO.ReservationPreviewDTO> previewList = reservations.getContent().stream()
                .map(ReservationConverter::toPreviewDTO)
                .collect(Collectors.toList());

        return ReservationResponseDTO.ReservationPreviewListDTO.builder()
                .reservationPreviewDTOList(previewList)
                .listSize(reservations.getSize())
                .totalPage(reservations.getTotalPages())
                .totalElements(reservations.getTotalElements())
                .isFirst(reservations.isFirst())
                .isLast(reservations.isLast())
                .build();
    }
}