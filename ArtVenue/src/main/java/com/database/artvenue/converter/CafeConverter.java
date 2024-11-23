package com.database.artvenue.converter;

import com.database.artvenue.domain.Cafe;
import com.database.artvenue.domain.User;
import com.database.artvenue.web.dto.cafe.CafeRequestDTO;

public class CafeConverter {
    public static Cafe toEntity(CafeRequestDTO.CafeDTO dto, User user) {
        return Cafe.builder()
                .name(dto.getName())
                .location(dto.getLocation())
                .capacity(dto.getCapacity())
                .rentalFee(dto.getRentalFee())
                .owner(user)
                .build();
    }
}