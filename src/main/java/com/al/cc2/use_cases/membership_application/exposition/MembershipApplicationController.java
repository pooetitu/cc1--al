package com.al.cc2.use_cases.membership_application.exposition;

import com.al.cc2.kernel.CommandBus;
import com.al.cc2.use_cases.contractor.application.ContractorDTO;
import com.al.cc2.use_cases.contractor.domain.Contractor;
import com.al.cc2.use_cases.location.application.LocationDTO;
import com.al.cc2.use_cases.membership.domain.Email;
import com.al.cc2.use_cases.membership.domain.Password;
import com.al.cc2.use_cases.membership_application.application.ApplyContractor;
import com.al.cc2.use_cases.membership_application.application.ApplyTradesman;
import com.al.cc2.use_cases.payment.domain.PaymentInformations;
import com.al.cc2.use_cases.tradesman.application.TradesmanDTO;
import com.al.cc2.use_cases.tradesman.domain.Tradesman;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/membership_application")
public class MembershipApplicationController {
    private final CommandBus commandBus;

    public MembershipApplicationController(CommandBus commandBus) {
        this.commandBus = commandBus;
    }

    @PostMapping(path = "/contractor", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ContractorDTO applyContractor(@RequestBody @Valid ContractorApplicationRequest request) throws Exception {
        Contractor contractor = commandBus.send(new ApplyContractor(new Email(request.email), new Password(request.password), new PaymentInformations(request.paymentInformations.cardNumber, request.paymentInformations.expirationDate, request.paymentInformations.paymentType), request.birthdate, request.firstname, request.lastname, request.subscriptionType));
        return new ContractorDTO(contractor.id().getValue(), contractor.getLastName(), contractor.getFirstName(), contractor.getEmail().getValue(), contractor.getBirthdate());
    }

    @PostMapping(path = "/tradesman", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public TradesmanDTO applyTradesman(@RequestBody @Valid TradesmanApplicationRequest request) throws Exception {
        Tradesman tradesman = commandBus.send(new ApplyTradesman(new Email(request.email), new Password(request.password), new PaymentInformations(request.paymentInformations.cardNumber, request.paymentInformations.expirationDate, request.paymentInformations.paymentType), request.subscriptionType, request.birthdate, request.firstname, request.lastname, request.longitude, request.latitude));
        return new TradesmanDTO(tradesman.id().getValue(), tradesman.getLastName(), tradesman.getFirstName(), tradesman.getEmail().getValue(), tradesman.getBirthdate(), new LocationDTO(tradesman.getLocation().id().getValue(), tradesman.getLocation().getLatitude(), tradesman.getLocation().getLongitude()));
    }
}
