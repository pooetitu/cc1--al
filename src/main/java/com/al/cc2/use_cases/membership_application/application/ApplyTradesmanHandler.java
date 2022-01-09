package com.al.cc2.use_cases.membership_application.application;

import com.al.cc2.kernel.ApplicationEvent;
import com.al.cc2.kernel.CommandHandler;
import com.al.cc2.kernel.EventDispatcher;
import com.al.cc2.use_cases.location.domain.LocationID;
import com.al.cc2.use_cases.location.domain.LocationRepository;
import com.al.cc2.use_cases.membership.domain.Membership;
import com.al.cc2.use_cases.membership.domain.MembershipID;
import com.al.cc2.use_cases.membership_application.domain.InvalidMembershipException;
import com.al.cc2.use_cases.tradesman.domain.Tradesman;
import com.al.cc2.use_cases.tradesman.domain.TradesmanBuilder;
import com.al.cc2.use_cases.tradesman.domain.TradesmanRepository;

import java.util.function.Predicate;

public class ApplyTradesmanHandler implements CommandHandler<ApplyTradesman, Tradesman> {
    private final TradesmanRepository tradesmanRepository;
    private final LocationRepository locationRepository;
    private final Predicate<Membership> membershipPredicate;
    private final EventDispatcher<ApplicationEvent> eventDispatcher;

    public ApplyTradesmanHandler(TradesmanRepository tradesmanRepository, LocationRepository locationRepository, Predicate<Membership> membershipPredicate, EventDispatcher<ApplicationEvent> eventDispatcher) {
        this.tradesmanRepository = tradesmanRepository;
        this.locationRepository = locationRepository;
        this.membershipPredicate = membershipPredicate;
        this.eventDispatcher = eventDispatcher;
    }

    @Override
    public Tradesman handle(ApplyTradesman command) throws InvalidMembershipException {
        final MembershipID membershipID = tradesmanRepository.nextId();
        final LocationID locationID = locationRepository.nextId();
        TradesmanBuilder tradesmanBuilder = new TradesmanBuilder();
        Tradesman tradesman = ((TradesmanBuilder) tradesmanBuilder
                .withMembershipID(membershipID)
                .withFirstName(command.firstName)
                .withLastName(command.lastName)
                .withEmail(command.email)
                .withPassword(command.password)
                .withBirthdate(command.birthdate)
                .withPaymentInformations(command.paymentInformations)
                .withSubscription().withSubscriptionType(command.subscriptionType).end())
                .withLocation().withLocationID(locationID).withLatitude(command.latitude).withLongitude(command.longitude).end()
                .build();

        if (!membershipPredicate.test(tradesman)) {
            throw new InvalidMembershipException();
        }
        eventDispatcher.dispatch(new MemberAppliedEvent(tradesman));
        tradesmanRepository.add(tradesman);
        return tradesman;
    }
}
