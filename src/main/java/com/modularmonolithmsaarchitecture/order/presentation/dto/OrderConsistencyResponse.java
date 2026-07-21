package com.modularmonolithmsaarchitecture.order.presentation.dto;

import com.modularmonolithmsaarchitecture.order.application.dto.OrderConsistencyView;

import java.math.BigDecimal;

public record OrderConsistencyResponse(
        Long orderId,
        BigDecimal storedTotal,
        BigDecimal recalculatedTotal,
        boolean consistent
) {
    public static OrderConsistencyResponse from(OrderConsistencyView view) {
        return new OrderConsistencyResponse(
                view.orderId(), view.storedTotal(), view.recalculatedTotal(), view.consistent());
    }
}
