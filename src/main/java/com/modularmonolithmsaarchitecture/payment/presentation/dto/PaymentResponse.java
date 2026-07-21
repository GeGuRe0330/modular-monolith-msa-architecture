package com.modularmonolithmsaarchitecture.payment.presentation.dto;

import com.modularmonolithmsaarchitecture.payment.application.dto.PaymentInfo;

import java.math.BigDecimal;

public record PaymentResponse(
        Long paymentId,
        BigDecimal amount,
        String status
) {
    public static PaymentResponse from(PaymentInfo info) {
        return new PaymentResponse(info.paymentId(), info.amount(), info.status().name());
    }
}
