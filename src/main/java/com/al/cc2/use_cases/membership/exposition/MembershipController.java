package com.al.cc2.use_cases.membership.exposition;

import com.al.cc2.kernel.CommandBus;
import com.al.cc2.kernel.QueryBus;
import com.al.cc2.use_cases.membership.application.RetrieveMemberships;
import com.al.cc2.use_cases.membership.domain.Membership;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MembershipController {
    private final CommandBus commandBus;
    private final QueryBus queryBus;

    public MembershipController(CommandBus commandBus, QueryBus queryBus) {
        this.commandBus = commandBus;
        this.queryBus = queryBus;
    }

    @GetMapping(path = "/memberships", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Membership> retrieveMemberships() {
        return queryBus.send(new RetrieveMemberships());
    }
}
