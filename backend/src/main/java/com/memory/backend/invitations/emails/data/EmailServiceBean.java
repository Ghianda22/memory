package com.memory.backend.invitations.emails.data;

public class EmailServiceBean {
    private final String emailAddress;
    private final String gameId;
    private final String gameName;

    EmailServiceBean(String emailAddress, String gameId, String gameName) {
        this.emailAddress = emailAddress;
        this.gameId = gameId;
        this.gameName = gameName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getGameId() {
        return gameId;
    }

    public String getGameName() {
        return gameName;
    }
}