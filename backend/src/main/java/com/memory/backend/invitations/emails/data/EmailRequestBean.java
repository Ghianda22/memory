package com.memory.backend.invitations.emails.data;

import java.util.List;

public final class EmailRequestBean {
    private final List<String> emailList;
    private final String gameId;
    private final String gameName;

    public EmailRequestBean(List<String> emailList, String gameId, String gameName) {
        this.emailList = emailList;
        this.gameId = gameId;
        this.gameName = gameName;
    }

    public List<String> getEmailList() {
        return emailList;
    }

    public String getGameId() {
        return gameId;
    }

    public String getGameName() {
        return gameName;
    }
}
