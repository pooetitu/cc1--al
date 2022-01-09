package com.al.cc2.use_cases.membership_application.exposition;

import javax.validation.constraints.NotNull;

public class TradesmanApplicationRequest extends MembershipApplicationRequest {
    @NotNull
    public float latitude;
    @NotNull
    public float longitude;
}
