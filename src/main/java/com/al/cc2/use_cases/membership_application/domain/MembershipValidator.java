package com.al.cc2.use_cases.membership_application.domain;

import com.al.cc2.kernel.ApplicationLogger;
import com.al.cc2.use_cases.membership.domain.Membership;

import java.util.function.Predicate;

public class MembershipValidator implements Predicate<Membership> {
    private final ApplicationLogger applicationLogger;

    public MembershipValidator(ApplicationLogger applicationLogger) {
        this.applicationLogger = applicationLogger;
    }

    @Override
    public boolean test(Membership membership) {
        applicationLogger.info("Valid membership for " + membership.getFirstName());
        return true;
    }
}
