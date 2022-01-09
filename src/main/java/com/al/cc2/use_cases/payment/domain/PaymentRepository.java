package com.al.cc2.use_cases.payment.domain;

import com.al.cc2.kernel.Repository;

import java.util.UUID;

public interface PaymentRepository extends Repository<PaymentID, Payment> {
    default PaymentID nextId() {
        return PaymentID.fromUUID(UUID.randomUUID());
    }
}
