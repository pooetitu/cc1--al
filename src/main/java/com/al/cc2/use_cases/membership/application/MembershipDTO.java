package com.al.cc2.use_cases.membership.application;

import com.al.cc2.use_cases.membership.domain.Membership;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

@JsonSerialize
public class MembershipDTO {
    public final String id;
    public final String lastname;
    public final String firstname;
    public final String email;
    public final Date birthdate;

    public MembershipDTO(String id, String lastname, String firstname, String email, Date birthdate) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.birthdate = birthdate;
    }

    public static MembershipDTO of(Membership membership) {
        return new MembershipDTO(membership.id().getValue(), membership.getLastName(), membership.getFirstName(), membership.getEmail().getValue(), membership.getBirthdate());
    }
}
