package com.memory.backend.invitations.emails.data;

import com.memory.backend.Icons;

import java.util.UUID;

public class EmailServiceBeanBuilder {
    private String emailAddress;
    private Icons avatar;
    private UUID gameId;
    private String gameName;

    public EmailServiceBeanBuilder setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public EmailServiceBeanBuilder setAvatar(Icons avatar) {
        this.avatar = avatar;
        return this;
    }

    public EmailServiceBeanBuilder setGameId(UUID gameId) {
        this.gameId = gameId;
        return this;
    }

    public EmailServiceBeanBuilder setGameName(String gameName) {
        this.gameName = gameName;
        return this;
    }

    public EmailServiceBean createEmailServiceBean() {
        return new EmailServiceBean(emailAddress, avatar, gameId, gameName);
    }
}