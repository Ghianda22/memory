package com.memory.backend.invitations.emails.data;

import lombok.*;

//@Data
public final class Email {
    private final String receiverEmail;
    private final String msgBody;
    private final String subject;
  //  private String subject = "Your invitation to a M3m0 game";
//    private String attachment;


    Email(String receiverEmail, String msgBody, String subject) {
        this.receiverEmail = receiverEmail;
        this.msgBody = msgBody;
        this.subject = subject;
    }

    public String getReceiverEmail() {
        return receiverEmail;
    }

    public String getMsgBody() {
        return msgBody;
    }

    public String getSubject() {
        return subject;
    }
}

