package com.al.cc2.use_cases.membership.domain;

import com.al.cc2.kernel.Repository;

import java.util.UUID;

public interface MembershipRepository extends Repository<MembershipID, Membership> {
    default MembershipID nextId() {
        return MembershipID.fromUUID(UUID.randomUUID());
    }
}
