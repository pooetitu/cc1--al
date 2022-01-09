package com.al.cc2.use_cases.membership_application.application;

import com.al.cc2.kernel.Command;
import com.al.cc2.use_cases.membership.domain.Email;
import com.al.cc2.use_cases.membership.domain.Password;
import com.al.cc2.use_cases.payment.domain.PaymentInformations;
import com.al.cc2.use_cases.subscription.domain.SubscriptionType;

import java.util.Date;

public class ApplyTradesman implements Command {
    public final Email email;
    public final Password password;
    public final PaymentInformations paymentInformations;
    public final SubscriptionType subscriptionType;
    public final Date birthdate;
    public final String firstName;
    public final String lastName;
    public final float longitude;
    public final float latitude;

    public ApplyTradesman(Email email, Password password, PaymentInformations paymentInformations, SubscriptionType subscriptionType, Date birthdate, String firstName, String lastName, float longitude, float latitude) {
        this.email = email;
        this.password = password;
        this.paymentInformations = paymentInformations;
        this.subscriptionType = subscriptionType;
        this.birthdate = birthdate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
