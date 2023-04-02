package com.memory.backend.invitations.emails.data.request;

import com.memory.backend.Icons;

public class EmailListRequestBuilder {
    private String emailAddress;
    private Icons avatar;

    public EmailListRequestBuilder setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public EmailListRequestBuilder setAvatar(Icons avatar) {
        this.avatar = avatar;
        return this;
    }

    public EmailListRequest createEmailListRequest() {
        return new EmailListRequest(emailAddress, avatar);
    }
}