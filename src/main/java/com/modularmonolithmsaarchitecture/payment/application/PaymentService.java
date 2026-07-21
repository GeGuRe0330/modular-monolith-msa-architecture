package com.modularmonolithmsaarchitecture.payment.application;

import com.modularmonolithmsaarchitecture.common.exception.EntityNotFoundException;
import com.modularmonolithmsaarchitecture.payment.application.dto.PaymentInfo;
import com.modularmonolithmsaarchitecture.payment.domain.PaymentStatus;
import com.modularmonolithmsaarchitecture.payment.domain.Payment;
import com.modularmonolithmsaarchitecture.payment.infrastructure.PaymentJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class PaymentService {
    private final PaymentJpaRepository paymentRepository;
    private final PaymentGateway paymentGateway;

    @Transactional
    public PaymentInfo pay(BigDecimal amount) {
        Payment payment = Payment.ready(amount);
        try {
            PaymentGateway.PgApproval approval = paymentGateway.approve(amount);
            payment.approve(approval.transactionId());
        } catch (RuntimeException e) {
            payment.fail();
            paymentRepository.save(payment);
            throw new IllegalStateException("결재 승인에 실패했습니다. amount: " + amount, e);
        }
        return PaymentInfo.from(paymentRepository.save(payment));
    }

    @Transactional
    public PaymentInfo cancel(Long paymentId) {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 결제입니다. paymentId: " + paymentId));

        paymentGateway.cancel(payment.getPgTransactionId());
        payment.cancel();
        return PaymentInfo.from(paymentRepository.save(payment));
    }

    @Transactional(readOnly = true)
    public PaymentInfo getPayment(Long paymentId) {
        Payment payment = paymentRepository.findById(paymentId)
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 결제입니다. paymentId: " + paymentId));
        return PaymentInfo.from(payment);
    }
}
