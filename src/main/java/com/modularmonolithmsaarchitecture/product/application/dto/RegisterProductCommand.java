package com.modularmonolithmsaarchitecture.product.application.dto;

import java.math.BigDecimal;

public record RegisterProductCommand(
        Long sellerId,
        String name,
        BigDecimal price,
        int stockQuantity,
        String description
) {
}
