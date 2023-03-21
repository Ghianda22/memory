package com.memory.backend.invitations.emails.data;

public class EmailBuilder {
    private String receiverEmail;
    private String msgBody;
    private String subject;

    public EmailBuilder setReceiverEmail(String receiverEmail) {
        this.receiverEmail = receiverEmail;
        return this;
    }

    public EmailBuilder setMsgBody(String msgBody) {
        this.msgBody = msgBody;
        return this;
    }

    public EmailBuilder setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public Email createEmail() {
        return new Email(receiverEmail, msgBody, subject);
    }
}