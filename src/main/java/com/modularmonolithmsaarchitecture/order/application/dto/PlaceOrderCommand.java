package com.modularmonolithmsaarchitecture.order.application.dto;

import java.util.List;

public record PlaceOrderCommand(Long userId, List<OrderLine> lines) {
}
