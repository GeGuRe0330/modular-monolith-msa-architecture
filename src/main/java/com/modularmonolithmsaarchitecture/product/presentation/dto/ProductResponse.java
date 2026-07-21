package com.modularmonolithmsaarchitecture.product.presentation.dto;

import com.modularmonolithmsaarchitecture.product.application.dto.ProductInfo;

import java.math.BigDecimal;

public record ProductResponse(
        Long id,
        Long sellerId,
        String name,
        BigDecimal price,
        int stockQuantity,
        String status,
        boolean orderable
) {
    public static ProductResponse from(ProductInfo info) {
        return new ProductResponse(
                info.id(),
                info.sellerId(),
                info.name(),
                info.price(),
                info.stockQuantity(),
                info.status().name(),
                info.isOrderable());
    }
}
