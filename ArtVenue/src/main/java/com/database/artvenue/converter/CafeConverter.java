package com.database.artvenue.converter;

import com.database.artvenue.domain.Cafe;
import com.database.artvenue.domain.User;
import com.database.artvenue.web.dto.cafe.CafeRequestDTO;
import com.database.artvenue.web.dto.cafe.CafeResponseDTO;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

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

    public static CafeResponseDTO.CafePreviewListDTO toCafePreviewListDTO(Page<Cafe> cafes) {
        List<CafeResponseDTO.CafePreviewDTO> cafePreviewDTOList = cafes.getContent().stream()
                .map(cafe -> toCafePreviewDTO(cafe))
                .collect(Collectors.toList());

        return CafeResponseDTO.CafePreviewListDTO.builder()
                .cafePreviewDTOList(cafePreviewDTOList)
                .listSize(cafes.getSize())
                .totalElements(cafes.getTotalElements())
                .isFirst(cafes.isFirst())
                .isLast(cafes.isLast())
                .totalPage(cafes.getTotalPages())
                .build();
    }

    private static CafeResponseDTO.CafePreviewDTO toCafePreviewDTO(Cafe cafe) {
        return CafeResponseDTO.CafePreviewDTO.builder()
                .cafeId(cafe.getCafeId())
                .name(cafe.getName())
                .location(cafe.getLocation())
                .build();
    }
}