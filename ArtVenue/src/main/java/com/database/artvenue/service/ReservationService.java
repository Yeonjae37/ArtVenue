package com.database.artvenue.service;

import com.database.artvenue.api.code.status.ErrorStatus;
import com.database.artvenue.api.exception.handler.UserHandler;
import com.database.artvenue.converter.EventConverter;
import com.database.artvenue.converter.HostEventConverter;
import com.database.artvenue.converter.PaymentConverter;
import com.database.artvenue.converter.ReservationConverter;
import com.database.artvenue.domain.*;
import com.database.artvenue.domain.mapping.HostEvent;
import com.database.artvenue.repository.*;
import com.database.artvenue.web.dto.reservation.ReservationRequestDTO;
import com.database.artvenue.web.dto.reservation.ReservationResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {
    private final CafeRepository cafeRepository;
    private final EventRepository eventRepository;
    private final UserRepository userRepository;
    private final ReservationRepository reservationRepository;
    private final HostEventRepository hostEventRepository;
    private final PaymentRepository paymentRepository;

    public ReservationService(CafeRepository cafeRepository, EventRepository eventRepository, UserRepository userRepository, ReservationRepository reservationRepository, HostEventRepository hostEventRepository, PaymentRepository paymentRepository) {
        this.cafeRepository = cafeRepository;
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
        this.reservationRepository = reservationRepository;
        this.hostEventRepository = hostEventRepository;
        this.paymentRepository = paymentRepository;
    }

    public void createReservation(ReservationRequestDTO.createReservationDTO request, Long userId){
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserHandler(ErrorStatus._USER_NOT_FOUND));
        Cafe cafe = cafeRepository.findById(request.getCafeId())
                .orElseThrow(() -> new UserHandler(ErrorStatus._CAFE_NOT_FOUND));

        Reservation reservation = ReservationConverter.toEntity(request, cafe);
        Reservation savedReservation = reservationRepository.save(reservation);

        Event event = EventConverter.toEntity(request, cafe, savedReservation);
        eventRepository.save(event);

        HostEvent hostEvent = HostEventConverter.toEntity(user, event, request);
        hostEventRepository.save(hostEvent);

        Payment payment = PaymentConverter.toEntity(savedReservation);
        paymentRepository.save(payment);
    }
    public ReservationResponseDTO.ReservationPreviewListDTO getReservationPreviewList(Integer page) {
        PageRequest pageRequest = PageRequest.of(page - 1, 10);
        Page<Reservation> reservations = reservationRepository.findAll(pageRequest);
        return ReservationConverter.toPreviewListDTO(reservations);
    }
}
