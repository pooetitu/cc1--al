package com.al.cc2.use_cases.contractor.domain;

import com.al.cc2.kernel.Repository;
import com.al.cc2.use_cases.membership.domain.MembershipID;

import java.util.UUID;

public interface ContractorRepository extends Repository<MembershipID, Contractor> {
    default MembershipID nextId() {
        return MembershipID.fromUUID(UUID.randomUUID());
    }
}
