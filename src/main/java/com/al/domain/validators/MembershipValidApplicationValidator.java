package com.al.domain.validators;

import com.al.domain.models.MembershipApplication;
import com.al.kernel.Logger;

public class MembershipValidApplicationValidator implements Predicate<MembershipApplication> {
    private final Logger logger;

    public MembershipValidApplicationValidator(Logger logger) {
        this.logger = logger;
    }

    @Override
    public boolean validate(MembershipApplication membership) {
        logger.info("Validated membership application for " + membership.firstName);
        return true;
    }
}
