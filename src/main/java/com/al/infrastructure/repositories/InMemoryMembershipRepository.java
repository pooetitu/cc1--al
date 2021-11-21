package com.al.infrastructure.repositories;

import com.al.domain.ids.MembershipID;
import com.al.domain.models.Membership;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;

public class InMemoryMembershipRepository implements MembershipRepository {
    private final HashMap<MembershipID, Membership> memberships;

    public InMemoryMembershipRepository() {
        this.memberships = new HashMap<>();
    }

    @Override
    public List<Membership> findAll() {
        return new ArrayList<>(memberships.values());
    }

    @Override
    public Membership byId(MembershipID membershipID) {
        Membership membership = memberships.get(membershipID);
        if (membership == null) {
            throw new NoSuchElementException();
        }
        return membership;
    }

    @Override
    public void update(MembershipID membershipID, Membership membership) {
        memberships.replace(membershipID, membership);
    }

    @Override
    public void add(Membership membership) {
        memberships.put(membership.id(), membership);
    }

    @Override
    public void delete(MembershipID membershipID) {
        memberships.remove(membershipID);
    }
}
