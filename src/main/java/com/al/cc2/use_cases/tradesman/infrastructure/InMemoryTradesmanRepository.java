package com.al.cc2.use_cases.tradesman.infrastructure;

import com.al.cc2.use_cases.membership.domain.MembershipID;
import com.al.cc2.use_cases.membership.domain.MembershipRepository;
import com.al.cc2.use_cases.tradesman.domain.Tradesman;
import com.al.cc2.use_cases.tradesman.domain.TradesmanRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

@Repository
public class InMemoryTradesmanRepository implements TradesmanRepository {
    private final HashMap<MembershipID, Tradesman> tradesmen;
    private final MembershipRepository membershipRepository;

    public InMemoryTradesmanRepository(MembershipRepository membershipRepository) {
        this.membershipRepository = membershipRepository;
        this.tradesmen = new HashMap<>();
    }

    @Override
    public List<Tradesman> findAll() {
        return new ArrayList<>(tradesmen.values());
    }

    @Override
    public Tradesman byId(MembershipID membershipID) {
        Tradesman tradesman = tradesmen.get(membershipID);
        if (tradesman == null) {
            throw new NoSuchElementException();
        }
        return tradesman;
    }

    @Override
    public void update(MembershipID membershipID, Tradesman tradesman) {
        tradesmen.replace(membershipID, tradesman);
    }

    @Override
    public void add(Tradesman tradesman) {
        tradesmen.put(tradesman.id(), tradesman);
        membershipRepository.add(tradesman);
    }

    @Override
    public void delete(MembershipID membershipID) {
        tradesmen.remove(membershipID);
    }
}
