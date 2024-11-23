package com.database.artvenue.web.dto.reservation;

import com.database.artvenue.domain.enums.StatusType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

public class ReservationResponseDTO {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class ReservationPreviewListDTO {
        List<ReservationResponseDTO.ReservationPreviewDTO> reservationPreviewDTOList;
        Integer listSize;
        Integer totalPage;
        Long totalElements;
        Boolean isFirst;
        Boolean isLast;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class ReservationPreviewDTO {
        Long reservationId;
        Date reservationDate;
        StatusType statusType;
        String name;
    }
}
