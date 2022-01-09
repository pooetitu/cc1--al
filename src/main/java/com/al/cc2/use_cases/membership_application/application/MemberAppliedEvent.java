package com.al.cc2.use_cases.membership_application.application;

import com.al.cc2.kernel.ApplicationEvent;
import com.al.cc2.use_cases.membership.domain.Membership;

public class MemberAppliedEvent implements ApplicationEvent {
    public final Membership membership;

    public MemberAppliedEvent(Membership membership) {
        super();
        this.membership = membership;
    }
}
