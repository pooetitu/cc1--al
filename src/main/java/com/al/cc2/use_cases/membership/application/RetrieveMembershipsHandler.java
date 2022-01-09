package com.al.cc2.use_cases.membership.application;

import com.al.cc2.kernel.QueryHandler;
import com.al.cc2.use_cases.membership.domain.MembershipRepository;

import java.util.List;
import java.util.stream.Collectors;

public class RetrieveMembershipsHandler implements QueryHandler<RetrieveMemberships, List<MembershipDTO>> {
    private final MembershipRepository membershipRepository;

    public RetrieveMembershipsHandler(MembershipRepository membershipRepository) {
        this.membershipRepository = membershipRepository;
    }

    @Override
    public List<MembershipDTO> handle(RetrieveMemberships query) {
        return membershipRepository.findAll()
                .stream()
                .map(MembershipDTO::of)
                .collect(Collectors.toList());
    }
}
