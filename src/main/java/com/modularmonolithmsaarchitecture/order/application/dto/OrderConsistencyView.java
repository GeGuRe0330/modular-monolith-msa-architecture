package com.modularmonolithmsaarchitecture.order.application.dto;

import java.math.BigDecimal;

public record OrderConsistencyView(
        Long orderId,
        BigDecimal storedTotal,
        BigDecimal recalculatedTotal,
        boolean consistent
) {
}
