package com.al.infrastructure.services;


import com.al.kernel.Logger;

public class StubPaymentService implements PaymentService {
    private final Logger logger;

    public StubPaymentService(Logger logger) {
        this.logger = logger;
    }

    @Override
    public boolean processPayment() {
        logger.info("Processed payment");
        return true;
    }
}
