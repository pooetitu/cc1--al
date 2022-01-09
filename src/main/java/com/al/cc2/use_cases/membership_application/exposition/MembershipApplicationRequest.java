package com.al.cc2.use_cases.membership_application.exposition;

import com.al.cc2.use_cases.subscription.domain.SubscriptionType;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public abstract class MembershipApplicationRequest {
    @Valid
    public PaymentInformationsRequest paymentInformations;
    @NotNull
    public Date birthdate;
    @NotNull
    @NotBlank
    public String email;
    @NotNull
    @NotBlank
    public String password;
    @NotNull
    @NotBlank
    public String firstname;
    @NotNull
    @NotBlank
    public String lastname;
    @NotNull
    public SubscriptionType subscriptionType;

    public PaymentInformationsRequest getPaymentInformations() {
        return paymentInformations;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }
}
