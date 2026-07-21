package com.modularmonolithmsaarchitecture.seller.presentation.dto;

import com.modularmonolithmsaarchitecture.seller.application.dto.SellerInfo;

public record SellerResponse(
        Long id,
        Long userId,
        String businessName,
        String status
) {
    public static SellerResponse from(SellerInfo info) {
        return new SellerResponse(info.id(), info.userId(), info.businessName(), info.status().name());
    }
}
