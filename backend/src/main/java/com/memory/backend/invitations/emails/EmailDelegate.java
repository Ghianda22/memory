package com.memory.backend.invitations.emails;

import com.memory.backend.invitations.emails.data.*;
import com.memory.backend.invitations.emails.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

/**
 * This class checks on data received from EmailController:
 */
@Component
public class EmailDelegate {
    private final EmailService emailService;
    private static final String EMAIL_REGEX_PATTERN = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

    @Autowired
    public EmailDelegate(EmailService emailService) {
        this.emailService = emailService;
    }


    public EmailResponseBean handleEmails(EmailRequestBean emailRequestBean) {
        EmailResponseBean emailResponseBean = new EmailResponseBeanBuilder()
                .createEmailResponseBean();

        for (String emailAddress : emailRequestBean.getEmailList()) {
            if(isAddressInvalid(emailAddress)) {
                EmailStatusBean emailStatusBean = new EmailStatusBeanBuilder()
                        .setEmailAddress(emailAddress)
                        .setStatusMessage("not a valid email address")
                        .createEmailStatusBean();
                emailResponseBean.getFailedEmail().add(emailStatusBean);
                continue;
            }

            EmailServiceBean emailServiceBean = new EmailServiceBeanBuilder()
                    .setEmailAddress(emailAddress)
                    .setGameId(emailRequestBean.getGameId())
                    .setGameName(emailRequestBean.getGameName())
                    .createEmailServiceBean();
            EmailStatusBean emailStatusBean = emailService.sendEmailInvitation(emailServiceBean);
            if(emailStatusBean != null) {
                emailResponseBean.getFailedEmail().add(emailStatusBean);
            }
        }

        return emailResponseBean;
    }

    boolean isAddressInvalid(String email){
        return !Pattern.compile(EMAIL_REGEX_PATTERN)
                .matcher(email)
                .matches();
    }
}
