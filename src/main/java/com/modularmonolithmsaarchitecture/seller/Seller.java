package com.modularmonolithmsaarchitecture.seller;

import com.modularmonolithmsaarchitecture.product.Product;

import com.modularmonolithmsaarchitecture.user.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "sellers")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    public static Seller create(Long userId) {
        Seller seller = new Seller();
        seller.userId = userId;

        return seller;
    }

}
