package com.al.cc2.use_cases.subscription.domain;

import com.al.cc2.use_cases.payment.domain.Payment;
import com.al.cc2.use_cases.payment.domain.PaymentStatus;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Subscription {
    private final SubscriptionType subscriptionType;
    private final List<Payment> payments;

    public Subscription(SubscriptionType subscriptionType) {
        this.subscriptionType = subscriptionType;
        this.payments = new ArrayList<>();
    }

    public SubscriptionType getSubscriptionType() {
        return subscriptionType;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public boolean isCurrentlyUnpaid() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);

        return payments.stream()
                .filter(previousPayment -> previousPayment.getPaymentStatus() == PaymentStatus.SUCCESS || previousPayment.getPaymentStatus() == PaymentStatus.PENDING)
                .noneMatch(previousPayment -> previousPayment.getPaymentDate().after(cal.getTime()));
    }
}
