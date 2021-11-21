package com.al.domain.validators;

import com.al.domain.models.MembershipApplication;
import com.al.kernel.Logger;

public class MembershipInvalidApplicationValidator implements Predicate<MembershipApplication> {
    private final Logger logger;

    public MembershipInvalidApplicationValidator(Logger logger) {
        this.logger = logger;
    }

    @Override
    public boolean validate(MembershipApplication membership) {
        logger.error("Invalid membership application for " + membership.firstName);
        return false;
    }
}
