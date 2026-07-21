package com.modularmonolithmsaarchitecture.order.presentation.dto;

import com.modularmonolithmsaarchitecture.order.application.dto.OrderResult;

import java.math.BigDecimal;

public record OrderResponse(
        Long id,
        String status,
        BigDecimal itemsAmount,
        BigDecimal shippingFee,
        BigDecimal totalAmount
) {
    public static OrderResponse from(OrderResult result) {
        return new OrderResponse(
                result.id(),
                result.status().name(),
                result.itemsAmount(),
                result.shippingFee(),
                result.totalAmount());
    }
}
