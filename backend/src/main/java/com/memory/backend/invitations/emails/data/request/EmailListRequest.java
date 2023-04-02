package com.memory.backend.invitations.emails.data.request;

import com.memory.backend.Icons;

public final class EmailListRequest {
    private final String emailAddress;
    private final Icons avatar;

    public EmailListRequest(String emailAddress, Icons avatar) {
        this.emailAddress = emailAddress;
        this.avatar = avatar;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public Icons getAvatar() {
        return avatar;
    }
}
