package com.al.cc2.use_cases.contractor.domain;

import com.al.cc2.domain.models.Project;
import com.al.cc2.use_cases.membership.domain.Email;
import com.al.cc2.use_cases.membership.domain.Membership;
import com.al.cc2.use_cases.membership.domain.MembershipID;
import com.al.cc2.use_cases.membership.domain.Password;
import com.al.cc2.use_cases.payment.domain.PaymentInformations;
import com.al.cc2.use_cases.subscription.domain.Subscription;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contractor extends Membership {
    private final List<Project> projects;

    public Contractor(MembershipID membershipID, Email email, Password password, PaymentInformations paymentInformations, Date birthdate, String firstName, String lastName, Subscription subscription) {
        super(membershipID, email, password, paymentInformations, birthdate, firstName, lastName, subscription);
        this.projects = new ArrayList<>();
    }

    public List<Project> getProjects() {
        return projects;
    }
}
