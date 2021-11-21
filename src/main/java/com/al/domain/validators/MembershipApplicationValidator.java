package com.al.domain.validators;

import com.al.domain.models.MembershipApplication;
import com.al.kernel.Logger;

public class MembershipApplicationValidator implements Predicate<MembershipApplication> {
    private final Logger logger;

    public MembershipApplicationValidator(Logger logger) {
        this.logger = logger;
    }

    @Override
    public boolean validate(MembershipApplication membership) {
        if (membership.age >= 18) {
            logger.info("Validated membership application for " + membership.firstName);
            return true;
        } else {
            logger.info("Invalid membership application for " + membership.firstName);
            return false;
        }
    }
}
