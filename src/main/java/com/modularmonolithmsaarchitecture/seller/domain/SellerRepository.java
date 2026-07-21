package com.modularmonolithmsaarchitecture.seller.domain;

import java.util.Optional;

public interface SellerRepository {
    Seller save(Seller seller);

    Optional<Seller> findById(Long id);

    boolean existsByUserId(Long userId);
}
