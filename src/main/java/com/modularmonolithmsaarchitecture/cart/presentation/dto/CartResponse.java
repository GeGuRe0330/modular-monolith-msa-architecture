package com.modularmonolithmsaarchitecture.cart.presentation.dto;

import com.modularmonolithmsaarchitecture.cart.application.dto.CartView;

import java.util.List;

public record CartResponse(
        Long cartId,
        Long userId,
        int itemCount,
        List<ItemResponse> items
) {
    public record ItemResponse(Long productId, int quantity) {}

    public static CartResponse from(CartView view) {
        List<ItemResponse> items = view.items().stream()
                .map(line -> new ItemResponse(line.productId(), line.quantity()))
                .toList();
        return new CartResponse(view.cartId(), view.userId(), items.size(), items);
    }
}
