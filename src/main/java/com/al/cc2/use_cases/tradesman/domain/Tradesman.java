package com.al.cc2.use_cases.tradesman.domain;

import com.al.cc2.domain.models.Education;
import com.al.cc2.domain.models.Skill;
import com.al.cc2.use_cases.location.domain.Location;
import com.al.cc2.use_cases.membership.domain.Email;
import com.al.cc2.use_cases.membership.domain.Membership;
import com.al.cc2.use_cases.membership.domain.MembershipID;
import com.al.cc2.use_cases.membership.domain.Password;
import com.al.cc2.use_cases.payment.domain.PaymentInformations;
import com.al.cc2.use_cases.subscription.domain.Subscription;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Tradesman extends Membership {
    private final Location location;
    private final List<Education> education;
    private final List<Skill> skills;

    public Tradesman(MembershipID membershipID, Email email, Password password, PaymentInformations paymentInformations, Date birthdate, String firstName, String lastName, Subscription subscription, Location location) {
        super(membershipID, email, password, paymentInformations, birthdate, firstName, lastName, subscription);
        this.location = location;
        this.education = new ArrayList<>();
        this.skills = new ArrayList<>();
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public Location getLocation() {
        return location;
    }

    public List<Education> getEducation() {
        return education;
    }
}
