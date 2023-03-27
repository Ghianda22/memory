package com.memory.backend.invitations.emails.data.request;

import com.memory.backend.Icons;

import java.util.List;

public class EmailRequestBeanBuilder {
    private List<EmailListRequest> emailList;
    private String gameId;
    private Icons avatar;
    private String gameName;

    public EmailRequestBeanBuilder setEmailList(List<EmailListRequest> emailList) {
        this.emailList = emailList;
        return this;
    }

    public EmailRequestBeanBuilder setGameId(String gameId) {
        this.gameId = gameId;
        return this;
    }

    public EmailRequestBeanBuilder setAvatar(Icons avatar) {
        this.avatar = avatar;
        return this;
    }

    public EmailRequestBeanBuilder setGameName(String gameName) {
        this.gameName = gameName;
        return this;
    }

    public EmailRequestBean createEmailRequestBean() {
        return new EmailRequestBean(emailList, gameId, avatar, gameName);
    }
}