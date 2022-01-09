package com.al.cc2.use_cases.membership_application.exposition;

import com.al.cc2.use_cases.contractor.application.ContractorDTO;
import com.al.cc2.use_cases.membership.domain.Membership;
import com.al.cc2.use_cases.membership.domain.MembershipID;
import com.al.cc2.use_cases.membership.domain.MembershipRepository;
import com.al.cc2.use_cases.payment.domain.PaymentType;
import com.al.cc2.use_cases.subscription.domain.SubscriptionType;
import com.al.cc2.use_cases.tradesman.application.TradesmanDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class MembershipApplicationControllerTest {
    @Autowired
    private MembershipApplicationController membershipApplicationController;
    @Autowired
    private MembershipRepository membershipRepository;

    @BeforeEach
    void setUp() {
    }

    @Test
    void applyContractor() throws Exception {
        PaymentInformationsRequest paymentInformationsRequest = new PaymentInformationsRequest();
        paymentInformationsRequest.paymentType = PaymentType.MASTERCARD;
        paymentInformationsRequest.cardNumber = "0000-0000-0000-0000";
        paymentInformationsRequest.expirationDate = new Date();

        ContractorApplicationRequest contractorApplicationRequest = new ContractorApplicationRequest();
        contractorApplicationRequest.subscriptionType = SubscriptionType.CLASSIC;
        contractorApplicationRequest.birthdate = new Date();
        contractorApplicationRequest.email = "mail@mail.com";
        contractorApplicationRequest.password = "password";
        contractorApplicationRequest.firstname = "Paul";
        contractorApplicationRequest.lastname = "Jack";
        contractorApplicationRequest.paymentInformations = paymentInformationsRequest;

        ContractorDTO contractor = membershipApplicationController.applyContractor(contractorApplicationRequest);
        Membership membership = membershipRepository.byId(MembershipID.of(contractor.id));
        assertNotNull(membership);
    }

    @Test
    void applyTradesman() throws Exception {
        PaymentInformationsRequest paymentInformationsRequest = new PaymentInformationsRequest();
        paymentInformationsRequest.paymentType = PaymentType.MASTERCARD;
        paymentInformationsRequest.cardNumber = "0000-0000-0000-0000";
        paymentInformationsRequest.expirationDate = new Date();

        TradesmanApplicationRequest tradesmanApplicationRequest = new TradesmanApplicationRequest();
        tradesmanApplicationRequest.subscriptionType = SubscriptionType.CLASSIC;
        tradesmanApplicationRequest.birthdate = new Date();
        tradesmanApplicationRequest.email = "mail@mail.com";
        tradesmanApplicationRequest.password = "password";
        tradesmanApplicationRequest.firstname = "Paul";
        tradesmanApplicationRequest.lastname = "Jack";
        tradesmanApplicationRequest.paymentInformations = paymentInformationsRequest;
        tradesmanApplicationRequest.latitude = 2.5f;
        tradesmanApplicationRequest.longitude = 3.8f;

        TradesmanDTO tradesman = membershipApplicationController.applyTradesman(tradesmanApplicationRequest);
        Membership membership = membershipRepository.byId(MembershipID.of(tradesman.id));
        assertNotNull(membership);
    }
}