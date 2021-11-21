package com.al.infrastructure.controllers;

import com.al.domain.models.MembershipApplication;
import com.al.infrastructure.services.MembershipService;


public class MembershipController {
    private final MembershipService membershipService;

    public MembershipController(MembershipService membershipService) {
        this.membershipService = membershipService;
    }

    public void addMembership(MembershipApplication membershipApplication) {
        membershipService.addMembership(membershipApplication);
    }
}
