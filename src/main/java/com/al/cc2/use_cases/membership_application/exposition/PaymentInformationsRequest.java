package com.al.cc2.use_cases.membership_application.exposition;

import com.al.cc2.use_cases.payment.domain.PaymentType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class PaymentInformationsRequest {
    @NotNull
    @NotBlank
    public String cardNumber;
    @NotNull
    public Date expirationDate;
    @NotNull
    public PaymentType paymentType;

    public String getCardNumber() {
        return cardNumber;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }
}
