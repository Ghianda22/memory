package com.memory.backend.invitations.emails.data;

public class EmailServiceBeanBuilder {
    private String emailAddress;
    private String gameId;
    private String gameName;

    public EmailServiceBeanBuilder setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public EmailServiceBeanBuilder setGameId(String gameId) {
        this.gameId = gameId;
        return this;
    }

    public EmailServiceBeanBuilder setGameName(String gameName) {
        this.gameName = gameName;
        return this;
    }

    public EmailServiceBean createEmailServiceBean() {
        return new EmailServiceBean(emailAddress, gameId, gameName);
    }
}