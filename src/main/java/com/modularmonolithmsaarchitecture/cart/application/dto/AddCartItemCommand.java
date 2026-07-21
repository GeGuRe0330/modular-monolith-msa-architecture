package com.modularmonolithmsaarchitecture.cart.application.dto;

public record AddCartItemCommand(Long userId, Long productId, int quantity) {
}
