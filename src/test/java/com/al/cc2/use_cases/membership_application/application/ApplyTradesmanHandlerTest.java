package com.al.cc2.use_cases.membership_application.application;

import com.al.cc2.kernel.CommandBus;
import com.al.cc2.use_cases.membership.domain.Email;
import com.al.cc2.use_cases.membership.domain.Membership;
import com.al.cc2.use_cases.membership.domain.Password;
import com.al.cc2.use_cases.membership_application.domain.InvalidMembershipException;
import com.al.cc2.use_cases.payment.domain.PaymentInformations;
import com.al.cc2.use_cases.payment.domain.PaymentType;
import com.al.cc2.use_cases.subscription.domain.SubscriptionType;
import com.al.cc2.use_cases.tradesman.domain.Tradesman;
import com.al.cc2.use_cases.tradesman.domain.TradesmanRepository;
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
class ApplyTradesmanHandlerTest {
    @Autowired
    private CommandBus commandBus;
    @Autowired
    private TradesmanRepository tradesmanRepository;

    @MockBean
    private Predicate<Membership> membershipPredicate;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(membershipPredicate.test(ArgumentMatchers.any(Membership.class))).thenReturn(true);
    }

    @Test
    void applyContractorWithValidMembership() throws Exception {
        ApplyTradesman applyTradesman = new ApplyTradesman(new Email("mail@mail.com"), new Password("password"), new PaymentInformations("0000-0000-0000-0000", new Date(), PaymentType.AMERICAN_EXPRESS), SubscriptionType.CLASSIC, new Date(), "Paul", "Jack", 20.5f, 40.3f);
        final Tradesman tradesman = commandBus.send(applyTradesman);
        final Tradesman storedTradesman = tradesmanRepository.byId(tradesman.id());

        assertEquals(tradesman, storedTradesman);
    }

    @Test
    void applyContractorWithInvalidMembership() {
        Mockito.when(membershipPredicate.test(ArgumentMatchers.any(Membership.class))).thenReturn(false);

        ApplyTradesman applyTradesman = new ApplyTradesman(new Email("mail@mail.com"), new Password("password"), new PaymentInformations("0000-0000-0000-0000", new Date(), PaymentType.AMERICAN_EXPRESS), SubscriptionType.CLASSIC, new Date(), "Paul", "Jack", 20.5f, 40.3f);

        assertThrows(InvalidMembershipException.class, () -> commandBus.send(applyTradesman));
    }
}