package com.database.artvenue.web.dto.cafe;

import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class CafeRequestDTO {
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CafeDTO {
        private Long userId;
        private String name;
        private String location;
        private Integer capacity;
        private Double rentalFee;
    }


}