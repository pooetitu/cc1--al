package com.al.cc2.use_cases.mail.infrastructure;

import com.al.cc2.use_cases.mail.domain.Mail;
import com.al.cc2.use_cases.membership.domain.Membership;

public interface MailService {
    void send(Mail mail, Membership membership);
}
