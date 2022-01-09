package com.al.cc2.use_cases.subscription.application;

import com.al.cc2.kernel.CommandBus;
import com.al.cc2.use_cases.membership.domain.Email;
import com.al.cc2.use_cases.membership.domain.Membership;
import com.al.cc2.use_cases.membership.domain.Password;
import com.al.cc2.use_cases.membership_application.application.ApplyTradesman;
import com.al.cc2.use_cases.payment.domain.PaymentInformations;
import com.al.cc2.use_cases.payment.domain.PaymentType;
import com.al.cc2.use_cases.subscription.domain.SubscriptionType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class ProcessSubscriptionPaymentsHandlerTest {
    @Autowired
    private CommandBus commandBus;

    @BeforeEach
    void setUp() {
    }

    @Test
    void processSubscriptionPayments() throws Exception {
        ApplyTradesman applyTradesman = new ApplyTradesman(new Email("mail@mail.com"), new Password("password"), new PaymentInformations("0000-0000-0000-0000", new Date(), PaymentType.AMERICAN_EXPRESS), SubscriptionType.CLASSIC, new Date(), "Paul", "Jack", 20.5f, 40.3f);
        Membership membership = commandBus.send(applyTradesman);
        membership.getSubscription().getPayments().clear();

        commandBus.send(new ProcessSubscriptionPayments());

        assertFalse(membership.getSubscription().isCurrentlyUnpaid());
    }
}