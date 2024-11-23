package com.database.artvenue.web.dto.cafe;

import lombok.Getter;

public class CafeRequestDTO {
    @Getter
    public static class CafeDTO {
        private Long userId;
        private String name;
        private String location;
        private Integer capacity;
        private Double rentalFee;
    }
}
