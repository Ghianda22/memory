package com.memory.backend.invitations.emails;

import com.memory.backend.invitations.emails.data.*;
import com.memory.backend.invitations.emails.data.request.EmailListRequest;
import com.memory.backend.invitations.emails.data.request.EmailRequestBean;
import com.memory.backend.invitations.emails.data.response.EmailResponseBean;
import com.memory.backend.invitations.emails.data.response.EmailResponseBeanBuilder;
import com.memory.backend.invitations.emails.data.response.EmailStatusBean;
import com.memory.backend.invitations.emails.data.response.EmailStatusBeanBuilder;
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

        for (EmailListRequest emailAddress : emailRequestBean.getEmailList()) {
            if(isAddressInvalid(emailAddress.getEmailAddress())) {
                EmailStatusBean emailStatusBean = new EmailStatusBeanBuilder()
                        .setEmailAddress(emailAddress.getEmailAddress())
                        .setStatusMessage("not a valid email address")
                        .createEmailStatusBean();
                emailResponseBean.getFailedEmail().add(emailStatusBean);
                continue;
            }

            EmailServiceBean emailServiceBean = new EmailServiceBeanBuilder()
                    .setEmailAddress(emailAddress.getEmailAddress())
                    .setAvatar(emailAddress.getAvatar())
                    .setGameId(emailRequestBean.getGameId())
                    .setGameName(emailRequestBean.getGameName())
                    .createEmailServiceBean();
            EmailStatusBean emailStatusBean = emailService.handleInvitations(emailServiceBean);
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
