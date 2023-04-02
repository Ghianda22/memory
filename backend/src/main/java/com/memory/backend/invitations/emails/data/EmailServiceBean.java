package com.memory.backend.invitations.emails.data;

import com.memory.backend.Icons;

import java.util.UUID;

public class EmailServiceBean {
    private final String emailAddress;
    private final Icons avatar;
    private final UUID gameId;
    private final String gameName;

    EmailServiceBean(String emailAddress, Icons avatar, UUID gameId, String gameName) {
        this.emailAddress = emailAddress;
        this.avatar = avatar;
        this.gameId = gameId;
        this.gameName = gameName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public UUID getGameId() {
        return gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public Icons getAvatar() {
        return avatar;
    }
}