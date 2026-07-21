package com.modularmonolithmsaarchitecture.seller.infrastructure;

import com.modularmonolithmsaarchitecture.seller.domain.Seller;
import com.modularmonolithmsaarchitecture.seller.domain.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class SellerRepositoryAdapter implements SellerRepository {
    private final SellerJpaRepository jpaRepository;

    @Override
    public Seller save(Seller seller) {
        return jpaRepository.save(seller);
    }

    @Override
    public Optional<Seller> findById(Long id) {
        return jpaRepository.findById(id);
    }

    @Override
    public boolean existsByUserId(Long userId) {
        return jpaRepository.existsById(userId);
    }
}
