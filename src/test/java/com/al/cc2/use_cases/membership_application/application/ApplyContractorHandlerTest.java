package com.al.cc2.use_cases.membership_application.application;

import com.al.cc2.kernel.CommandBus;
import com.al.cc2.use_cases.contractor.domain.Contractor;
import com.al.cc2.use_cases.contractor.domain.ContractorRepository;
import com.al.cc2.use_cases.membership.domain.Email;
import com.al.cc2.use_cases.membership.domain.Membership;
import com.al.cc2.use_cases.membership.domain.Password;
import com.al.cc2.use_cases.membership_application.domain.InvalidMembershipException;
import com.al.cc2.use_cases.payment.domain.PaymentInformations;
import com.al.cc2.use_cases.payment.domain.PaymentType;
import com.al.cc2.use_cases.subscription.domain.SubscriptionType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class ApplyContractorHandlerTest {
    @Autowired
    private CommandBus commandBus;
    @Autowired
    private ContractorRepository contractorRepository;

    @MockBean
    private Predicate<Membership> membershipPredicate;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(membershipPredicate.test(ArgumentMatchers.any(Membership.class))).thenReturn(true);
    }

    @Test
    void applyContractorWithValidMembership() throws Exception {
        ApplyContractor applyContractor = new ApplyContractor(new Email("mail@mail.com"), new Password("password"), new PaymentInformations("0000-0000-0000-0000", new Date(), PaymentType.AMERICAN_EXPRESS), new Date(), "Paul", "Jack", SubscriptionType.PREMIUM);
        final Contractor contractor = commandBus.send(applyContractor);
        final Contractor storedContractor = contractorRepository.byId(contractor.id());

        assertEquals(contractor, storedContractor);
    }

    @Test
    void applyContractorWithInvalidMembership() {
        Mockito.when(membershipPredicate.test(ArgumentMatchers.any(Membership.class))).thenReturn(false);

        ApplyContractor applyContractor = new ApplyContractor(new Email("mail@mail.com"), new Password("password"), new PaymentInformations("0000-0000-0000-0000", new Date(), PaymentType.AMERICAN_EXPRESS), new Date(), "Paul", "Jack", SubscriptionType.PREMIUM);

        assertThrows(InvalidMembershipException.class, () -> commandBus.send(applyContractor));
    }
}