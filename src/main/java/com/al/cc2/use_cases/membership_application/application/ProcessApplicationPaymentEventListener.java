package com.al.cc2.use_cases.membership_application.application;

import com.al.cc2.kernel.ApplicationLogger;
import com.al.cc2.kernel.EventListener;
import com.al.cc2.use_cases.payment.domain.Payment;
import com.al.cc2.use_cases.payment.domain.PaymentID;
import com.al.cc2.use_cases.payment.domain.PaymentRepository;
import com.al.cc2.use_cases.payment.domain.PaymentStatus;
import com.al.cc2.use_cases.payment.infrastructure.PaymentService;

import java.util.Date;

public class ProcessApplicationPaymentEventListener implements EventListener<MemberAppliedEvent> {
    private final ApplicationLogger applicationLogger;
    private final PaymentService paymentService;
    private final PaymentRepository paymentRepository;

    public ProcessApplicationPaymentEventListener(ApplicationLogger applicationLogger, PaymentService paymentService, PaymentRepository paymentRepository) {
        this.applicationLogger = applicationLogger;
        this.paymentService = paymentService;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public void listen(MemberAppliedEvent event) {
        PaymentID paymentID = paymentRepository.nextId();
        Payment payment = new Payment(paymentID, event.membership.getSubscription().getSubscriptionType().getPrice());
        event.membership.addPayment(payment);
        event.membership.getSubscription().getPayments().add(payment);
        try {
            paymentService.processPayment(payment, event.membership.getPaymentInformations());
            payment.setPaymentStatus(PaymentStatus.SUCCESS);
            applicationLogger.info("Successfully processed subscription payment for " + event.membership.getFirstName());
        } catch (Exception e) {
            payment.setPaymentStatus(PaymentStatus.FAILED);
            applicationLogger.info("Failed to process subscription payment for " + event.membership.getFirstName());
        } finally {
            payment.setPaymentDate(new Date(System.currentTimeMillis()));
        }
    }
}
