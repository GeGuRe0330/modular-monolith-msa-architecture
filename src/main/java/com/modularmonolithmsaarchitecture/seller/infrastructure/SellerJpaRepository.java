package com.modularmonolithmsaarchitecture.seller.infrastructure;

import com.modularmonolithmsaarchitecture.seller.domain.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerJpaRepository extends JpaRepository<Seller, Long> {
    boolean existsByUserId(Long userId);
}
