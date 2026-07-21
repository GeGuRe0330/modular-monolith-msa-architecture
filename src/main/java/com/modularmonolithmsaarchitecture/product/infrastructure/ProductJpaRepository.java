package com.modularmonolithmsaarchitecture.product.infrastructure;

import com.modularmonolithmsaarchitecture.product.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<Product, Long> {
}
