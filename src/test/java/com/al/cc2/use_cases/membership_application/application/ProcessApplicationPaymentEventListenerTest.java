package com.al.cc2.use_cases.membership_application.application;

import com.al.cc2.kernel.ApplicationLogger;
import com.al.cc2.kernel.CommandBus;
import com.al.cc2.use_cases.membership.domain.Email;
import com.al.cc2.use_cases.membership.domain.Password;
import com.al.cc2.use_cases.payment.domain.*;
import com.al.cc2.use_cases.payment.infrastructure.PaymentService;
import com.al.cc2.use_cases.subscription.domain.SubscriptionType;
import com.al.cc2.use_cases.tradesman.domain.Tradesman;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ProcessApplicationPaymentEventListenerTest {
    @Autowired
    private CommandBus commandBus;
    @Autowired
    private ApplicationLogger logger;
    @Autowired
    private PaymentRepository paymentRepository;
    @MockBean
    @Qualifier("paymentService")
    private PaymentService paymentService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        Mockito.reset(paymentService);
    }

    @Test
    void processApplicationPayment() throws Exception {
        ApplyTradesman applyTradesman = new ApplyTradesman(new Email("mail@mail.com"), new Password("password"), new PaymentInformations("0000-0000-0000-0000", new Date(), PaymentType.AMERICAN_EXPRESS), SubscriptionType.CLASSIC, new Date(), "Paul", "Jack", 20.5f, 40.3f);
        final Tradesman tradesman = commandBus.send(applyTradesman);

        assertEquals(PaymentStatus.SUCCESS, tradesman.getPayments().get(0).getPaymentStatus());
    }

    @Test
    void processApplicationPaymentFailed() throws Exception {
        Mockito.doThrow(PaymentProcessException.class).when(paymentService).processPayment(Mockito.any(Payment.class), Mockito.any(PaymentInformations.class));
        ApplyTradesman applyTradesman = new ApplyTradesman(new Email("mail@mail.com"), new Password("password"), new PaymentInformations("0000-0000-0000-0000", new Date(), PaymentType.AMERICAN_EXPRESS), SubscriptionType.CLASSIC, new Date(), "Paul", "Jack", 20.5f, 40.3f);
        final Tradesman tradesman = commandBus.send(applyTradesman);

        assertEquals(PaymentStatus.FAILED, tradesman.getPayments().get(0).getPaymentStatus());
    }
}