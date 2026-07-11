package com.modularmonolithmsaarchitecture.product;

import com.modularmonolithmsaarchitecture.seller.Seller;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Seller seller;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal price;

    @Setter
    @Column(nullable = false)
    private Integer stockQuantity;

    @Lob
    private String description;

    public static Product create(Seller seller, String name, BigDecimal price, Integer stockQuantity, String description) {
        Product product = new Product();
        product.seller = seller;
        product.name = name;
        product.price = price;
        product.stockQuantity = stockQuantity;
        return product;
    }

}
