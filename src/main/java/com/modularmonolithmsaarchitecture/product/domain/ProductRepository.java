package com.modularmonolithmsaarchitecture.product.domain;

import java.util.Optional;

public interface ProductRepository {
    Product save(Product product);

    Optional<Product> findById(Long id);
}
