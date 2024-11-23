package com.database.artvenue.web.controller;

import com.database.artvenue.api.ApiResponse;
import com.database.artvenue.api.code.status.SuccessStatus;
import com.database.artvenue.service.CafeService;
import com.database.artvenue.web.dto.cafe.CafeRequestDTO;
import com.database.artvenue.web.dto.cafe.CafeResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

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

    @Operation(summary = "전체 카페 목록 조회 api", description = "전체 카페 목록을 가져오는 api입니다.")
    @GetMapping
    public ApiResponse getCafes(@RequestParam(name = "page") Integer page) {
        CafeResponseDTO.CafePreviewListDTO response = cafeService.getCafePreviewList(page);
        return ApiResponse.of(SuccessStatus._GET_LIST_CAFE_OK, response);
    }

    @Operation(summary = "카페 상세 조회 api", description = "카페 상세 정보를 가져오는 api입니다.")
    @GetMapping("detail/{cafeId}")
    public ApiResponse getCafe(@PathVariable Long cafeId) {
        CafeResponseDTO.CafeDetailDTO response = cafeService.getCafeDetail(cafeId);
        return ApiResponse.of(SuccessStatus._GET_CAFE_OK, response);
    }
}