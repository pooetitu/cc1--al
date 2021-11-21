package com.al;

import com.al.domain.models.MembershipApplication;
import com.al.domain.validators.MembershipApplicationValidator;
import com.al.infrastructure.controllers.MembershipController;
import com.al.infrastructure.repositories.InMemoryMembershipRepository;
import com.al.infrastructure.services.MembershipService;
import com.al.infrastructure.services.StubPaymentService;
import com.al.kernel.ConsoleLogger;

public class Main {
    public static void main(String[] args) {
        var logger = new ConsoleLogger();
        var membershipValidator = new MembershipApplicationValidator(logger);
        var paymentService = new StubPaymentService(logger);
        var membershipRepository = new InMemoryMembershipRepository();
        var membershipService = new MembershipService(membershipRepository, membershipValidator, paymentService);
        var membershipController = new MembershipController(membershipService);

        var validMembership = new MembershipApplication();
        validMembership.firstName = "Jack";
        validMembership.age = 19;
        membershipController.addMembership(validMembership);

        var invalidMembership = new MembershipApplication();
        invalidMembership.firstName = "Paul";
        invalidMembership.age = 17;
        membershipController.addMembership(invalidMembership);
    }
}
