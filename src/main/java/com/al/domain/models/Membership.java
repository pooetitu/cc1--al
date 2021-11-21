package com.al.domain.models;

import com.al.domain.ids.MembershipID;
import com.al.kernel.Entity;

public class Membership implements Entity<MembershipID> {
    private final MembershipID membershipID;
    private final String mail;
    private final String firstName;
    private final String lastName;
    private final int age;
    private String password;

    public Membership(MembershipID membershipID, String mail, String firstName, String lastName, String password, int age) {
        this.membershipID = membershipID;
        this.mail = mail;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.age = age;
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

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
