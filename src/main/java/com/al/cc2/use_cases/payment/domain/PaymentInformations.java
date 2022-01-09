package com.al.cc2.use_cases.payment.domain;

import java.util.Date;

public class PaymentInformations {
    private final String creditCardNumber;
    private final Date creditCardExpiration;
    private final PaymentType paymentType;

    public PaymentInformations(String creditCardNumber, Date creditCardExpiration, PaymentType paymentType) {
        this.creditCardNumber = creditCardNumber;
        this.creditCardExpiration = creditCardExpiration;
        this.paymentType = paymentType;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public Date getCreditCardExpiration() {
        return creditCardExpiration;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }
}
