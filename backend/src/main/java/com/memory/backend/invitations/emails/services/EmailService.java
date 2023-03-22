package com.memory.backend.invitations.emails.services;

import com.memory.backend.invitations.emails.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EmailService {
    private static final String baseUrl = "http://localhost:3000/livegame";
    private final EmailSenderServiceImpl emailSenderService;

    @Autowired
    public EmailService(EmailSenderServiceImpl emailSenderService) {
        this.emailSenderService = emailSenderService;
    }


    public String generateInvitationLink(String gameId) {
        UUID uuid = UUID.randomUUID();
        return String.format("%s/%s/%s", baseUrl, gameId, uuid);
    }

    /**
     * 1. generate the link
     * 2. set email message with the link
     * 3. call email sender service
     * @param emailServiceBean = object containing a single email address, the game id and the game name
     */
    public EmailStatusBean sendEmailInvitation(EmailServiceBean emailServiceBean) {
        String link = generateInvitationLink(emailServiceBean.getGameId());

        Email email = new EmailBuilder()
                .setReceiverEmail(emailServiceBean.getEmailAddress())
                .setMsgBody("Ehy! You have been invited to " + emailServiceBean.getGameName() + " match" +
                        "\nHere is the link to access\n\n" + link)
                .createEmail();
        try {
            emailSenderService.sendSimpleMessage(email);
            return null;
        } catch (MailException e) {
            System.out.println(e.getMessage());
            return new EmailStatusBeanBuilder()
                    .setEmailAddress(emailServiceBean.getEmailAddress())
                    .setStatusMessage("A network error occurred")
                    .createEmailStatusBean();
        }

    }

}
