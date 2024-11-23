package com.database.artvenue.web.controller;

import com.database.artvenue.api.ApiResponse;
import com.database.artvenue.api.code.status.SuccessStatus;
import com.database.artvenue.service.PaymentService;
import com.database.artvenue.web.dto.cafe.CafeRequestDTO;
import com.database.artvenue.web.dto.payment.PaymentRequestDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/payment")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Operation(summary = "예약 결제하기", description = "결제하는 api입니다.")
    @PostMapping
    public ApiResponse makePayment(@RequestBody PaymentRequestDTO.CreatePaymentDTO request) {
        paymentService.makePayment(request);
        return ApiResponse.of(SuccessStatus._PAYMENT_SUCCESS, null);
    }

}
