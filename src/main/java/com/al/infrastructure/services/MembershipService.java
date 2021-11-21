package com.al.infrastructure.services;

import com.al.domain.ids.MembershipID;
import com.al.domain.models.Membership;
import com.al.domain.models.MembershipApplication;
import com.al.domain.validators.Predicate;
import com.al.infrastructure.repositories.MembershipRepository;

import java.util.List;

public class MembershipService {
    private final MembershipRepository membershipRepository;
    private final Predicate<MembershipApplication> membershipApplicationValidator;
    private final PaymentService paymentService;

    public MembershipService(MembershipRepository membershipRepository, Predicate<MembershipApplication> membershipApplicationValidator, PaymentService paymentService) {
        this.membershipRepository = membershipRepository;
        this.membershipApplicationValidator = membershipApplicationValidator;
        this.paymentService = paymentService;
    }

    public void addMembership(MembershipApplication membershipApplication) {
        if(membershipApplicationValidator.validate(membershipApplication) && paymentService.processPayment()) {
            final MembershipID membershipId = membershipRepository.nextId();
            membershipRepository.add(new Membership(membershipId, membershipApplication.mail,
                    membershipApplication.firstName, membershipApplication.lastName, membershipApplication.password, membershipApplication.age));
        }
    }

    public Membership getById(MembershipID membershipID) {
        return membershipRepository.byId(membershipID);
    }

    public List<Membership> getAll() {
        return membershipRepository.findAll();
    }
}
