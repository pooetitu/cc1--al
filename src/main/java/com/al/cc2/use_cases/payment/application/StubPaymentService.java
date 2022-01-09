package com.al.cc2.use_cases.payment.application;


import com.al.cc2.kernel.ApplicationLogger;
import com.al.cc2.use_cases.payment.domain.Payment;
import com.al.cc2.use_cases.payment.domain.PaymentInformations;
import com.al.cc2.use_cases.payment.domain.PaymentProcessException;
import com.al.cc2.use_cases.payment.infrastructure.PaymentService;
import org.springframework.stereotype.Service;


@Service
public class StubPaymentService implements PaymentService {
    private final ApplicationLogger applicationLogger;

    public StubPaymentService(ApplicationLogger applicationLogger) {
        this.applicationLogger = applicationLogger;
    }

    @Override
    public void processPayment(Payment payment, PaymentInformations paymentInformations) throws PaymentProcessException {
        applicationLogger.info("Contacting " + paymentInformations.getPaymentType() + " provider to process payment of " + payment.getAmount() + "$.");
    }
}
