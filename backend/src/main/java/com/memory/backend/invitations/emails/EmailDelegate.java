package com.memory.backend.invitations.emails;

import com.memory.backend.exceptions.InvalidEmailException;
import com.memory.backend.invitations.emails.data.EmailRequestBean;
import com.memory.backend.invitations.emails.data.EmailServiceBean;
import com.memory.backend.invitations.emails.data.EmailServiceBeanBuilder;
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
//    private static final String EMAIL_REGEX_PATTERN = "^(.+)@(\\S+)$";
    private static final String EMAIL_REGEX_PATTERN = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$";


    @Autowired
    public EmailDelegate(EmailService emailService) {
        this.emailService = emailService;
    }

    public void handleEmails(EmailRequestBean emailRequestBean) throws InvalidEmailException {
        for (String emailAddress : emailRequestBean.getEmailList()) {
            if(isAddressInvalid(emailAddress)) {
                throw new InvalidEmailException("%s is not a valid email address".formatted(emailAddress));
            }
            EmailServiceBean emailServiceBean = new EmailServiceBeanBuilder()
                    .setEmailAddress(emailAddress)
                    .setGameId(emailRequestBean.getGameId())
                    .setGameName(emailRequestBean.getGameName())
                    .createEmailServiceBean();
            emailService.sendEmailInvitation(emailServiceBean);
        }
    }

    boolean isAddressInvalid(String email){
        return !Pattern.compile(EMAIL_REGEX_PATTERN)
                .matcher(email)
                .matches();
    }
}
