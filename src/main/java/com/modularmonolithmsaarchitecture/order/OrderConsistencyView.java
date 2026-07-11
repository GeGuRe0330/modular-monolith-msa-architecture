package com.modularmonolithmsaarchitecture.order;

import java.math.BigDecimal;

public record OrderConsistencyView(
        Long orderId,
        BigDecimal storedTotal,
        BigDecimal recalculatedTotal,
        boolean consistent
) {
}
