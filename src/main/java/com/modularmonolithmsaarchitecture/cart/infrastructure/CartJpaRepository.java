package com.modularmonolithmsaarchitecture.cart.infrastructure;

import com.modularmonolithmsaarchitecture.cart.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartJpaRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByUserId(Long userId);
}
