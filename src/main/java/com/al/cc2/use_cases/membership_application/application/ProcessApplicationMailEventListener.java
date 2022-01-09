package com.al.cc2.use_cases.membership_application.application;

import com.al.cc2.kernel.EventListener;
import com.al.cc2.use_cases.mail.domain.Mail;
import com.al.cc2.use_cases.mail.infrastructure.MailService;

public class ProcessApplicationMailEventListener implements EventListener<MemberAppliedEvent> {
    private final MailService mailService;

    public ProcessApplicationMailEventListener(MailService mailService) {
        this.mailService = mailService;
    }

    @Override
    public void listen(MemberAppliedEvent event) {
        mailService.send(new Mail("Welcome " + event.membership.getFirstName(), "Welcome " + event.membership.getFirstName()), event.membership);
    }
}
