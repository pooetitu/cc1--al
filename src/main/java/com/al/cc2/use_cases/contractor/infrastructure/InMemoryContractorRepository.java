package com.al.cc2.use_cases.contractor.infrastructure;

import com.al.cc2.use_cases.contractor.domain.Contractor;
import com.al.cc2.use_cases.contractor.domain.ContractorRepository;
import com.al.cc2.use_cases.contractor.domain.NoSuchContractorException;
import com.al.cc2.use_cases.membership.domain.MembershipID;
import com.al.cc2.use_cases.membership.domain.MembershipRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class InMemoryContractorRepository implements ContractorRepository {
    private final HashMap<MembershipID, Contractor> contractors;
    private final MembershipRepository membershipRepository;

    public InMemoryContractorRepository(MembershipRepository membershipRepository) {
        this.membershipRepository = membershipRepository;
        this.contractors = new HashMap<>();
    }

    @Override
    public List<Contractor> findAll() {
        return new ArrayList<>(contractors.values());
    }

    @Override
    public Contractor byId(MembershipID contractorID) {
        Contractor contractor = contractors.get(contractorID);
        if (contractor == null) {
            throw new NoSuchContractorException();
        }
        return contractor;
    }

    @Override
    public void update(MembershipID membershipID, Contractor contractor) {
        contractors.replace(membershipID, contractor);
    }

    @Override
    public void add(Contractor contractor) {
        contractors.put(contractor.id(), contractor);
        membershipRepository.add(contractor);
    }

    @Override
    public void delete(MembershipID contractorID) {
        contractors.remove(contractorID);
    }
}
