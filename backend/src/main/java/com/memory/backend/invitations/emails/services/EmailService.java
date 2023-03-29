package com.memory.backend.invitations.emails.services;

import com.memory.backend.exceptions.NotFoundOnDbException;
import com.memory.backend.invitations.emails.data.*;
import com.memory.backend.invitations.emails.data.response.EmailStatusBean;
import com.memory.backend.invitations.emails.data.response.EmailStatusBeanBuilder;
import com.memory.backend.invitations.emails.data.persistence.InvitationEntity;
import com.memory.backend.invitations.emails.data.persistence.InvitationEntityBuilder;
import com.memory.backend.invitations.emails.data.persistence.InvitationRepository;
import com.memory.backend.invitations.emails.data.persistence.InvitationStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class EmailService {
    private static final String BASE_URL = "http://localhost:3000/livegame/invitations";

    private final EmailSenderServiceImpl emailSenderService;
    private final InvitationRepository invitationRepository;

    @Autowired
    public EmailService(EmailSenderServiceImpl emailSenderService, InvitationRepository invitationRepository) {
        this.emailSenderService = emailSenderService;
        this.invitationRepository = invitationRepository;
    }


//    --- METHODS -------------------------------------------------------------------------------------------------

    public EmailStatusBean handleInvitations(EmailServiceBean emailServiceBean){
        InvitationEntity invitationEntity = new InvitationEntityBuilder()
                .setGameId(emailServiceBean.getGameId())
                .setAvatar(emailServiceBean.getAvatar())
                .createInvitationEntity();
        UUID uuidInvitation = saveInvitationOnDb(invitationEntity);
        EmailStatusBean emailStatusBean = sendEmailInvitation(emailServiceBean, uuidInvitation);
        if(emailStatusBean == null){
            try {
                updateInvitationSent(uuidInvitation);
            } catch (NotFoundOnDbException e) {
                return new EmailStatusBeanBuilder()
                        .setEmailAddress(emailServiceBean.getEmailAddress())
                        .setStatusMessage("Something went wrong with the db\n" + e.getMessage())
                        .createEmailStatusBean();
            }
        }
        return emailStatusBean;
    }



//  --- DB MANAGEMENT ---------------------------------------

    UUID saveInvitationOnDb(InvitationEntity invitation){
        return invitationRepository.save(invitation).getId();
    }

    void updateInvitationSent (UUID invitationId) throws NotFoundOnDbException {
        Optional<InvitationEntity> savedInvitation = invitationRepository.findById(invitationId);
        if (savedInvitation.isEmpty()){
            throw new NotFoundOnDbException();
        }
//        TODO: fix this aberrant infraction of the immutability of data
        savedInvitation.get().setStatus(InvitationStatus.INVITED);
        invitationRepository.save(savedInvitation.get());

    }



//  --- EMAIL MANAGEMENT ---------------------------------------

    public String generateInvitationLink(UUID invitationId) {
        return "%s/%s".formatted(BASE_URL,invitationId);
    }

    /**
     * 1. generate the link
     * 2. set email message with the link
     * 3. call email sender service
     * @param emailServiceBean = object containing a single email address, the game id and the game name
     * @param invitationId = uuid to identify the invitation
     */
    public EmailStatusBean sendEmailInvitation(EmailServiceBean emailServiceBean, UUID invitationId) {
        String link = generateInvitationLink(invitationId);

        Email email = new EmailBuilder()
                .setReceiverEmail(emailServiceBean.getEmailAddress())
                .setMsgBody("Ehy! You have been invited to %s match\nHere is the link to access\n\n %s"
                        .formatted(emailServiceBean.getGameName(), link))
                .setSubject("Memory Game invitation")
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
