package com.memory.backend.invitations.emails.data;

import java.util.List;

public class EmailRequestBeanBuilder {
    private List<String> emailList;
    private String gameId;
    private String gameName;

    public EmailRequestBeanBuilder setEmailList(List<String> emailList) {
        this.emailList = emailList;
        return this;
    }

    public EmailRequestBeanBuilder setGameId(String gameId) {
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