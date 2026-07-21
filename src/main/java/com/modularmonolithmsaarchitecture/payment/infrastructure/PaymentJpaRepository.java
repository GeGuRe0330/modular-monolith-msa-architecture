package com.modularmonolithmsaarchitecture.payment.infrastructure;

import com.modularmonolithmsaarchitecture.payment.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentJpaRepository extends JpaRepository<Payment, Long> {
}
