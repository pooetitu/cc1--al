package com.al.cc2.use_cases.mail.application;

import com.al.cc2.kernel.ApplicationLogger;
import com.al.cc2.use_cases.mail.domain.Mail;
import com.al.cc2.use_cases.mail.infrastructure.MailService;
import com.al.cc2.use_cases.membership.domain.Membership;


public class StubMailService implements MailService {
    private final ApplicationLogger logger;

    public StubMailService(ApplicationLogger logger) {
        this.logger = logger;
    }

    @Override
    public void send(Mail mail, Membership membership) {
        logger.info("Sending mail to " + membership.getEmail().getValue() + " with body " + mail.getBody());
    }
}
