package com.memory.backend.invitations.emails.data.request;

import java.util.List;
import java.util.UUID;

public final class EmailRequestBean {
    private final List<EmailListRequest> emailList;
    private final UUID gameId;
    private final String gameName; //unnecessary, can be queried from game table with gameId

    EmailRequestBean(List<EmailListRequest> emailList, UUID gameId, String gameName) {
        this.emailList = emailList;
        this.gameId = gameId;
        this.gameName = gameName;
    }

    public List<EmailListRequest> getEmailList() {
        return emailList;
    }

    public UUID getGameId() {
        return gameId;
    }

    public String getGameName() {
        return gameName;
    }

}
