package com.al.cc2.use_cases.tradesman.application;

import com.al.cc2.use_cases.location.application.LocationDTO;
import com.al.cc2.use_cases.membership.application.MembershipDTO;

import java.util.Date;

public class TradesmanDTO extends MembershipDTO {
    public final LocationDTO location;

    public TradesmanDTO(String id, String lastname, String firstname, String email, Date birthdate, LocationDTO location) {
        super(id, lastname, firstname, email, birthdate);
        this.location = location;
    }
}
