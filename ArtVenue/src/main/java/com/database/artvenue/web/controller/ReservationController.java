package com.database.artvenue.web.controller;

import com.database.artvenue.api.ApiResponse;
import com.database.artvenue.api.code.status.SuccessStatus;
import com.database.artvenue.service.ReservationService;
import com.database.artvenue.web.dto.cafe.CafeResponseDTO;
import com.database.artvenue.web.dto.reservation.ReservationRequestDTO;
import com.database.artvenue.web.dto.reservation.ReservationResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/reservation")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @Operation(summary = "카페 예약 api", description = "Host가 카페를 예약하는 api입니다.")
    @PostMapping
    public ApiResponse createReservation(@RequestBody ReservationRequestDTO.createReservationDTO request, @RequestParam Long userId) {
        reservationService.createReservation(request, userId);
        return ApiResponse.of(SuccessStatus._CREATE_RESERVATION_OK, null);
    }

    @Operation(summary = "예약 조회 api", description = "나의 예약을 모두 조회하는 api입니다.")
    @GetMapping
    public ApiResponse getReservations(@RequestParam(name = "page") Integer page) {
        ReservationResponseDTO.ReservationPreviewListDTO response = reservationService.getReservationPreviewList(page);
        return ApiResponse.of(SuccessStatus._GET_LIST_RESERVATION_OK, response);
    }
}