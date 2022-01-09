package com.al.cc2.use_cases.contractor.application;

import com.al.cc2.use_cases.membership.application.MembershipDTO;

import java.util.Date;

public class ContractorDTO extends MembershipDTO {

    public ContractorDTO(String id, String lastname, String firstname, String email, Date birthdate) {
        super(id, lastname, firstname, email, birthdate);
    }
}
