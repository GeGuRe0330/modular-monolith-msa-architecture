package com.modularmonolithmsaarchitecture.product.presentation;

import com.modularmonolithmsaarchitecture.common.response.ApiResponse;
import com.modularmonolithmsaarchitecture.product.application.ProductService;
import com.modularmonolithmsaarchitecture.product.presentation.dto.ProductResponse;
import com.modularmonolithmsaarchitecture.product.presentation.dto.RegisterProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ApiResponse<ProductResponse> register(@RequestBody RegisterProductRequest request) {
        return ApiResponse.ok(ProductResponse.from(productService.register(request.toCommand())));
    }

    @GetMapping("/{productId}")
    public ApiResponse<ProductResponse> getProduct(@PathVariable Long productId) {
        return ApiResponse.ok(ProductResponse.from(productService.getProductInfo(productId)));
    }

    @PatchMapping("/{productId}/price")
    public ApiResponse<ProductResponse> changePrice(@PathVariable Long productId, @RequestParam BigDecimal price) {
        return ApiResponse.ok(ProductResponse.from(productService.changePrice(productId, price)));
    }
}
