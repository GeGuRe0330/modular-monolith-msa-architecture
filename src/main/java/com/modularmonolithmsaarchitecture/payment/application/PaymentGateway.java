package com.modularmonolithmsaarchitecture.payment.application;

import java.math.BigDecimal;

public interface PaymentGateway {
    PgApproval approve(BigDecimal amount);

    void cancel(String pgTransactionId);

    record PgApproval(String transactionId) {}
}
