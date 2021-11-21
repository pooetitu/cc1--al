package com.al.infrastructure.repositories;

import com.al.domain.ids.MembershipID;
import com.al.domain.models.Membership;
import com.al.kernel.Repository;

import java.util.UUID;

public interface MembershipRepository extends Repository<MembershipID, Membership> {
    default MembershipID nextId() {
        return MembershipID.fromUUID(UUID.randomUUID());
    }
}
