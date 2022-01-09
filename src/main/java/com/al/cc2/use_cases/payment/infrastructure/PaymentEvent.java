package com.al.cc2.use_cases.payment.infrastructure;

import com.al.cc2.kernel.ApplicationEvent;
import com.al.cc2.use_cases.payment.domain.Payment;
import com.al.cc2.use_cases.payment.domain.PaymentInformations;

public class PaymentEvent implements ApplicationEvent {
    public final Payment payment;
    public final PaymentInformations paymentInformations;

    public PaymentEvent(Payment payment, PaymentInformations paymentInformations) {
        this.payment = payment;
        this.paymentInformations = paymentInformations;
    }
}
