package com.al.cc2.use_cases.payment.infrastructure;

import com.al.cc2.use_cases.payment.domain.Payment;
import com.al.cc2.use_cases.payment.domain.PaymentInformations;
import com.al.cc2.use_cases.payment.domain.PaymentProcessException;

public interface PaymentService {
    void processPayment(Payment payment, PaymentInformations paymentInformations) throws PaymentProcessException;
}
