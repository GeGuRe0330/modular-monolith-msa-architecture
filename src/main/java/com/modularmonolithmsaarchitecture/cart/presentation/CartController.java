package com.modularmonolithmsaarchitecture.cart.presentation;

import com.modularmonolithmsaarchitecture.cart.application.CartService;
import com.modularmonolithmsaarchitecture.cart.presentation.dto.AddCartItemRequest;
import com.modularmonolithmsaarchitecture.cart.presentation.dto.CartResponse;
import com.modularmonolithmsaarchitecture.common.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users/{userId}/cart")
public class CartController {
    private final CartService cartService;

    @GetMapping
    public ApiResponse<CartResponse> getCart(@PathVariable Long userId) {
        return ApiResponse.ok(CartResponse.from(cartService.getCart(userId)));
    }

    @PostMapping("/items")
    public ApiResponse<CartResponse> addItem(@PathVariable Long userId, @RequestBody AddCartItemRequest request) {
        return ApiResponse.ok(CartResponse.from(cartService.addItem(request.toCommand(userId))));
    }

    @PatchMapping("items/{productId}")
    public ApiResponse<CartResponse> changeQuantity(@PathVariable Long userId, @PathVariable Long productId, @RequestParam int quantity) {
        return  ApiResponse.ok(CartResponse.from(cartService.changeQuantity(userId, productId, quantity)));
    }

    @DeleteMapping("items/{productId}")
    public ApiResponse<CartResponse> removeItem(@PathVariable Long userId, @PathVariable Long productId) {
        return ApiResponse.ok(CartResponse.from(cartService.removeItem(userId, productId)));
    }

    @DeleteMapping
    public ApiResponse<Void> clear(@PathVariable Long userId) {
        cartService.clear(userId);
        return ApiResponse.ok();
    }
}
