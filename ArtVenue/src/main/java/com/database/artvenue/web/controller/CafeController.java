package com.database.artvenue.web.controller;

import com.database.artvenue.api.ApiResponse;
import com.database.artvenue.api.code.status.SuccessStatus;
import com.database.artvenue.service.CafeService;
import com.database.artvenue.web.dto.cafe.CafeRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/cafe")
public class CafeController {
    private final CafeService cafeService;

    public CafeController(CafeService cafeService) {
        this.cafeService = cafeService;
    }

    @Operation(summary = "카페 등록하기", description = "카페를 등록하는 api입니다.")
    @PostMapping
    public ApiResponse addCafe(@RequestBody CafeRequestDTO.CafeDTO request) {
        cafeService.addCafe(request);

        return ApiResponse.of(SuccessStatus._CAFE_OK, null);
    }
}