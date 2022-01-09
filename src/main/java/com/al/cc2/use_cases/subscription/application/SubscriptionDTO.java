package com.al.cc2.use_cases.subscription.application;

import com.al.cc2.use_cases.location.domain.LocationID;
import com.al.cc2.use_cases.membership.application.MembershipDTO;

public class SubscriptionDTO {
    public final LocationID contractorID;
    public final MembershipDTO membershipDTO;

    public SubscriptionDTO(LocationID contractorID, MembershipDTO membershipDTO) {
        this.contractorID = contractorID;
        this.membershipDTO = membershipDTO;
    }
}
