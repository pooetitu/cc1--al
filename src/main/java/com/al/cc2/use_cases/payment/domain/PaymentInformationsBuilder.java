package com.al.cc2.use_cases.payment.domain;

import java.util.Date;

public class PaymentInformationsBuilder {
    private String creditCardNumber;
    private Date creditCardExpiration;
    private PaymentType paymentType;

    public PaymentInformations build() {
        return new PaymentInformations(creditCardNumber, creditCardExpiration, paymentType);
    }

    public PaymentInformationsBuilder withCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
        return this;
    }

    public PaymentInformationsBuilder withCreditCardExpiration(Date creditCardExpiration) {
        this.creditCardExpiration = creditCardExpiration;
        return this;
    }

    public PaymentInformationsBuilder withPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
        return this;
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