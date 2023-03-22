package com.memory.backend.invitations.emails.data;

public class EmailStatusBeanBuilder {
    private String emailAddress;
    private String statusMessage;

    public EmailStatusBeanBuilder setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public EmailStatusBeanBuilder setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
        return this;
    }

    public EmailStatusBean createEmailStatusBean() {
        return new EmailStatusBean(emailAddress, statusMessage);
    }
}