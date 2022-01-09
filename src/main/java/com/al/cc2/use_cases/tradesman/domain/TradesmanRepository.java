package com.al.cc2.use_cases.tradesman.domain;


import com.al.cc2.kernel.Repository;
import com.al.cc2.use_cases.membership.domain.MembershipID;

import java.util.UUID;

public interface TradesmanRepository extends Repository<MembershipID, Tradesman> {
    default MembershipID nextId() {
        return MembershipID.fromUUID(UUID.randomUUID());
    }
}
