package com.al.cc2.use_cases.membership.domain;

import com.al.cc2.use_cases.payment.domain.PaymentInformations;
import com.al.cc2.use_cases.subscription.domain.SubscriptionType;

import java.util.Date;

public abstract class MembershipBuilder {
    protected MembershipID membershipID;
    protected Email email;
    protected Password password;
    protected Date birthdate;
    protected String firstName;
    protected String lastName;
    protected PaymentInformations paymentInformations;
    protected SubscriptionBuilder subscriptionBuilder;

    protected MembershipBuilder() {
        this.subscriptionBuilder = new SubscriptionBuilder();
    }

    public MembershipBuilder withMembershipID(MembershipID membershipID) {
        this.membershipID = membershipID;
        return this;
    }

    public MembershipBuilder withEmail(Email email) {
        this.email = email;
        return this;
    }

    public MembershipBuilder withPassword(Password password) {
        this.password = password;
        return this;
    }

    public MembershipBuilder withBirthdate(Date birthdate) {
        this.birthdate = birthdate;
        return this;
    }

    public MembershipBuilder withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public MembershipBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public MembershipBuilder withPaymentInformations(PaymentInformations paymentInformations) {
        this.paymentInformations = paymentInformations;
        return this;
    }

    public SubscriptionBuilder withSubscription() {
        return subscriptionBuilder;
    }


    public class SubscriptionBuilder {
        private SubscriptionType subscriptionType;

        public MembershipBuilder end() {
            return MembershipBuilder.this;
        }

        public SubscriptionBuilder withSubscriptionType(SubscriptionType subscriptionType) {
            this.subscriptionType = subscriptionType;
            return this;
        }

        public SubscriptionType getSubscriptionType() {
            return subscriptionType;
        }
    }
}
