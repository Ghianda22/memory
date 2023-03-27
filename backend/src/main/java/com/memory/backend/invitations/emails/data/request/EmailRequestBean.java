package com.memory.backend.invitations.emails.data.request;

import com.memory.backend.Icons;

import java.util.List;

public final class EmailRequestBean {
    private final List<EmailListRequest> emailList;
    private final String gameId;
    private final Icons avatar;
    private final String gameName; //unnecessary, can be queried from game table with gameId

    EmailRequestBean(List<EmailListRequest> emailList, String gameId, Icons avatar, String gameName) {
        this.emailList = emailList;
        this.gameId = gameId;
        this.avatar = avatar;
        this.gameName = gameName;
    }

    public List<EmailListRequest> getEmailList() {
        return emailList;
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
