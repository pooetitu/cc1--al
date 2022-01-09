package com.al.cc2.use_cases.subscription.application;

import com.al.cc2.kernel.ApplicationLogger;
import com.al.cc2.kernel.CommandHandler;
import com.al.cc2.use_cases.membership.domain.Membership;
import com.al.cc2.use_cases.membership.domain.MembershipRepository;
import com.al.cc2.use_cases.payment.domain.*;
import com.al.cc2.use_cases.payment.infrastructure.PaymentService;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class ProcessSubscriptionPaymentsHandler implements CommandHandler<ProcessSubscriptionPayments, Void> {
    private final ApplicationLogger logger;
    private final MembershipRepository membershipRepository;
    private final PaymentService paymentService;
    private final PaymentRepository paymentRepository;

    public ProcessSubscriptionPaymentsHandler(ApplicationLogger logger, MembershipRepository membershipRepository, PaymentService paymentService, PaymentRepository paymentRepository) {
        this.logger = logger;
        this.membershipRepository = membershipRepository;
        this.paymentService = paymentService;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Void handle(ProcessSubscriptionPayments command) {
        List<Membership> memberships = membershipRepository.findAll()
                .stream()
                .filter(membership -> membership.getSubscription().isCurrentlyUnpaid())
                .collect(Collectors.toList());

        memberships.forEach(membership -> {
            logger.info("Processing subscription payment for user " + membership.getFirstName());
            PaymentID paymentID = paymentRepository.nextId();
            Payment payment = new Payment(paymentID, membership.getSubscription().getSubscriptionType().getPrice());
            membership.getPayments().add(payment);
            membership.getSubscription().getPayments().add(payment);
            try {
                paymentService.processPayment(payment, membership.getPaymentInformations());
                payment.setPaymentStatus(PaymentStatus.SUCCESS);
            } catch (PaymentProcessException e) {
                payment.setPaymentStatus(PaymentStatus.FAILED);
                logger.warning("Failed to process payment for " + membership.getFirstName());
            } finally {
                payment.setPaymentDate(new Date());
            }
        });
        logger.info("Processed subscription payment for " + memberships.size() + " members");

        return null;
    }
}
