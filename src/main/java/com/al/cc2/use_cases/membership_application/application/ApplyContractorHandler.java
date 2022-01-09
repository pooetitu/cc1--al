package com.al.cc2.use_cases.membership_application.application;

import com.al.cc2.kernel.ApplicationEvent;
import com.al.cc2.kernel.CommandHandler;
import com.al.cc2.kernel.EventDispatcher;
import com.al.cc2.use_cases.contractor.domain.Contractor;
import com.al.cc2.use_cases.contractor.domain.ContractorRepository;
import com.al.cc2.use_cases.membership.domain.Membership;
import com.al.cc2.use_cases.membership.domain.MembershipID;
import com.al.cc2.use_cases.membership_application.domain.InvalidMembershipException;
import com.al.cc2.use_cases.subscription.domain.Subscription;

import java.util.function.Predicate;

public class ApplyContractorHandler implements CommandHandler<ApplyContractor, Contractor> {
    private final ContractorRepository contractorRepository;
    private final Predicate<Membership> membershipPredicate;
    private final EventDispatcher<ApplicationEvent> eventDispatcher;

    public ApplyContractorHandler(ContractorRepository contractorRepository, Predicate<Membership> membershipPredicate, EventDispatcher<ApplicationEvent> eventDispatcher) {
        this.contractorRepository = contractorRepository;
        this.membershipPredicate = membershipPredicate;
        this.eventDispatcher = eventDispatcher;
    }

    @Override
    public Contractor handle(ApplyContractor command) throws InvalidMembershipException {
        final MembershipID membershipID = contractorRepository.nextId();
        Contractor contractor = new Contractor(membershipID, command.email, command.password, command.paymentInformations, command.birthdate, command.firstName, command.lastName, new Subscription(command.subscriptionType));

        if (!membershipPredicate.test(contractor)) {
            throw new InvalidMembershipException();
        }
        eventDispatcher.dispatch(new MemberAppliedEvent(contractor));
        contractorRepository.add(contractor);
        return contractor;
    }
}
