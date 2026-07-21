package com.modularmonolithmsaarchitecture.payment.application.dto;

import com.modularmonolithmsaarchitecture.payment.domain.Payment;
import com.modularmonolithmsaarchitecture.payment.domain.PaymentStatus;

import java.math.BigDecimal;

public record PaymentInfo(
        Long paymentId,
        BigDecimal amount,
        PaymentStatus status
) {
    public static PaymentInfo from(Payment payment) {
        return new PaymentInfo(payment.getId(), payment.getAmount(), payment.getStatus());
    }
}
