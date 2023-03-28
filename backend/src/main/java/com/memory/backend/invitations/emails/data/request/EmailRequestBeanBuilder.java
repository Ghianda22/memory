package com.memory.backend.invitations.emails.data.request;

import com.memory.backend.Icons;

import java.util.List;
import java.util.UUID;

public class EmailRequestBeanBuilder {
    private List<EmailListRequest> emailList;
    private UUID gameId;
    private String gameName;

    public EmailRequestBeanBuilder setEmailList(List<EmailListRequest> emailList) {
        this.emailList = emailList;
        return this;
    }

    public EmailRequestBeanBuilder setGameId(UUID gameId) {
        this.gameId = gameId;
        return this;
    }

    public EmailRequestBeanBuilder setGameName(String gameName) {
        this.gameName = gameName;
        return this;
    }

    public EmailRequestBean createEmailRequestBean() {
        return new EmailRequestBean(emailList, gameId, gameName);
    }
}