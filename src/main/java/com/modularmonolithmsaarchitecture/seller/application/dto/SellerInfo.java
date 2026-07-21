package com.modularmonolithmsaarchitecture.seller.application.dto;

import com.modularmonolithmsaarchitecture.seller.domain.Seller;
import com.modularmonolithmsaarchitecture.seller.domain.SellerStatus;

public record SellerInfo(
        Long id,
        Long userId,
        String businessName,
        SellerStatus status
) {
    public static SellerInfo from(Seller seller) {
        return new SellerInfo(seller.getId(), seller.getUserId(), seller.getBusinessName(), seller.getStatus());
    }
}
