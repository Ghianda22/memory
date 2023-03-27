package com.memory.backend.invitations.emails.data;

import com.memory.backend.Icons;

public class EmailServiceBean {
    private final String emailAddress;
    private final Icons avatar;
    private final String gameId;
    private final String gameName;

    EmailServiceBean(String emailAddress, Icons avatar, String gameId, String gameName) {
        this.emailAddress = emailAddress;
        this.avatar = avatar;
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

    public Icons getAvatar() {
        return avatar;
    }
}