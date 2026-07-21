package com.modularmonolithmsaarchitecture.order.application.dto;

import com.modularmonolithmsaarchitecture.order.domain.Order;
import com.modularmonolithmsaarchitecture.order.domain.OrderStatus;

import java.math.BigDecimal;

public record OrderResult(
        Long id,
        OrderStatus status,
        BigDecimal itemsAmount,
        BigDecimal shippingFee,
        BigDecimal totalAmount
) {
    public static OrderResult from(Order order) {
        return new OrderResult(
                order.getId(),
                order.getStatus(),
                order.getItemsAmount().getValue(),
                order.getShippingFee().getValue(),
                order.getTotalAmount().getValue()
        );
    }
}
