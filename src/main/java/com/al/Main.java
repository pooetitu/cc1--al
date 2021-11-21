package com.al;

import com.al.domain.models.MembershipApplication;
import com.al.domain.validators.MembershipInvalidApplicationValidator;
import com.al.domain.validators.MembershipValidApplicationValidator;
import com.al.infrastructure.controllers.MembershipController;
import com.al.infrastructure.repositories.InMemoryMembershipRepository;
import com.al.infrastructure.services.MembershipService;
import com.al.infrastructure.services.StubPaymentService;
import com.al.kernel.ConsoleLogger;

public class Main {
    public static void main(String[] args) {
        var logger = new ConsoleLogger();
        var membershipValidValidator = new MembershipValidApplicationValidator(logger);
        var membershipInvalidValidator = new MembershipInvalidApplicationValidator(logger);

        var paymentService = new StubPaymentService(logger);
        var membershipRepository = new InMemoryMembershipRepository();
        var membershipValidService = new MembershipService(membershipRepository, membershipValidValidator, paymentService);
        var membershipValidController = new MembershipController(membershipValidService);
        membershipValidController.addMembership(new MembershipApplication());


        var membershipInvalidService = new MembershipService(membershipRepository, membershipInvalidValidator, paymentService);
        var membershipInvalidController = new MembershipController(membershipInvalidService);
        membershipInvalidController.addMembership(new MembershipApplication());
    }
}
