package com.modularmonolithmsaarchitecture.payment.presentation;

import com.modularmonolithmsaarchitecture.common.response.ApiResponse;
import com.modularmonolithmsaarchitecture.payment.application.PaymentService;
import com.modularmonolithmsaarchitecture.payment.presentation.dto.PaymentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentService paymentService;

    @GetMapping("/{paymentId}")
    public ApiResponse<PaymentResponse> getPayment(@PathVariable Long paymentId) {
        return ApiResponse.ok(PaymentResponse.from(paymentService.getPayment(paymentId)));
    }
}
