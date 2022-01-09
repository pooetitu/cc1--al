package com.al.cc2;

import com.al.cc2.kernel.*;
import com.al.cc2.use_cases.contractor.domain.ContractorRepository;
import com.al.cc2.use_cases.location.domain.LocationRepository;
import com.al.cc2.use_cases.mail.application.StubMailService;
import com.al.cc2.use_cases.mail.infrastructure.MailService;
import com.al.cc2.use_cases.membership.application.RetrieveMemberships;
import com.al.cc2.use_cases.membership.application.RetrieveMembershipsHandler;
import com.al.cc2.use_cases.membership.domain.Membership;
import com.al.cc2.use_cases.membership.domain.MembershipRepository;
import com.al.cc2.use_cases.membership_application.application.*;
import com.al.cc2.use_cases.membership_application.domain.MembershipValidator;
import com.al.cc2.use_cases.payment.application.StubPaymentService;
import com.al.cc2.use_cases.payment.domain.PaymentRepository;
import com.al.cc2.use_cases.payment.infrastructure.PaymentService;
import com.al.cc2.use_cases.subscription.application.ProcessSubscriptionPayments;
import com.al.cc2.use_cases.subscription.application.ProcessSubscriptionPaymentsHandler;
import com.al.cc2.use_cases.tradesman.domain.TradesmanRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

@Configuration
public class ApplicationConfiguration {
    private final MembershipRepository membershipRepository;
    private final ContractorRepository contractorRepository;
    private final TradesmanRepository tradesmanRepository;
    private final PaymentRepository paymentRepository;
    private final LocationRepository locationRepository;

    public ApplicationConfiguration(MembershipRepository membershipRepository, ContractorRepository contractorRepository, TradesmanRepository tradesmanRepository, PaymentRepository paymentRepository, LocationRepository locationRepository) {
        this.membershipRepository = membershipRepository;
        this.contractorRepository = contractorRepository;
        this.tradesmanRepository = tradesmanRepository;
        this.paymentRepository = paymentRepository;
        this.locationRepository = locationRepository;
    }

    @Bean
    public ApplicationLogger applicationLogger() {
        return new ConsoleApplicationLogger();
    }

    @Bean
    public Predicate<Membership> membershipPredicate() {
        return new MembershipValidator(applicationLogger());
    }

    @Bean
    public QueryBus queryBus() {
        final Map<Class<? extends Query>, QueryHandler> queryHandlers = new HashMap<>();
        queryHandlers.put(RetrieveMemberships.class, new RetrieveMembershipsHandler(membershipRepository));
        return new DefaultQueryBus(queryHandlers);
    }

    @Bean
    public CommandBus commandBus() {
        final Map<Class<? extends Command>, CommandHandler> commandHandlers = new HashMap<>();
        commandHandlers.put(ApplyContractor.class, new ApplyContractorHandler(contractorRepository, membershipPredicate(), eventDispatcher()));
        commandHandlers.put(ApplyTradesman.class, new ApplyTradesmanHandler(tradesmanRepository, locationRepository, membershipPredicate(), eventDispatcher()));
        commandHandlers.put(ProcessSubscriptionPayments.class, new ProcessSubscriptionPaymentsHandler(applicationLogger(), membershipRepository, paymentService(), paymentRepository));
        return new DefaultCommandBus(commandHandlers);
    }

    @Bean
    public EventDispatcher<ApplicationEvent> eventDispatcher() {
        final Map<Class<? extends Event>, List<EventListener<? extends Event>>> listenerMap = new HashMap<>();
        listenerMap.put(MemberAppliedEvent.class, List.of(new ProcessApplicationPaymentEventListener(applicationLogger(), paymentService(), paymentRepository), new ProcessApplicationMailEventListener(mailService())));
        return new DefaultEventDispatcher(listenerMap);
    }

    @Bean
    public PaymentService paymentService() {
        return new StubPaymentService(applicationLogger());
    }

    @Bean
    public MailService mailService() {
        return new StubMailService(applicationLogger());
    }
}
