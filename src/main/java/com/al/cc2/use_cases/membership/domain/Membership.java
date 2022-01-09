package com.al.cc2.use_cases.membership.domain;

import com.al.cc2.kernel.Entity;
import com.al.cc2.use_cases.payment.domain.Payment;
import com.al.cc2.use_cases.payment.domain.PaymentInformations;
import com.al.cc2.use_cases.subscription.domain.Subscription;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Membership implements Entity<MembershipID> {
    private final MembershipID membershipID;
    private final Email email;
    private final Password password;
    private final PaymentInformations paymentInformations;
    private final Date birthdate;
    private final String firstName;
    private final String lastName;
    private final Subscription subscription;
    private final List<Payment> payments;

    protected Membership(MembershipID membershipID, Email email, Password password, PaymentInformations paymentInformations, Date birthdate, String firstName, String lastName, Subscription subscription) {
        this.membershipID = membershipID;
        this.email = email;
        this.paymentInformations = paymentInformations;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.birthdate = birthdate;
        this.subscription = subscription;
        this.payments = new ArrayList<>();
    }

    @Override
    public MembershipID id() {
        return membershipID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Email getEmail() {
        return email;
    }

    public Password getPassword() {
        return password;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public PaymentInformations getPaymentInformations() {
        return paymentInformations;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void addPayment(Payment payment) {
        payments.add(payment);
    }
}
