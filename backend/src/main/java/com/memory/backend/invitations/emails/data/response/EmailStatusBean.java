package com.memory.backend.invitations.emails.data.response;

public final class EmailStatusBean {
    private final String emailAddress;
    private final String statusMessage;

    EmailStatusBean(String emailAddress, String statusMessage) {
        this.emailAddress = emailAddress;
        this.statusMessage = statusMessage;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    @Override
    public String toString() {
        return "%s : %s \n".formatted(emailAddress, statusMessage);
    }
}
