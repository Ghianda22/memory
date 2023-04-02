package com.memory.backend.invitations.emails.data.response;

import java.util.ArrayList;

public class EmailResponseBeanBuilder {
    private ArrayList<EmailStatusBean> failedEmail = new ArrayList<>();

    public EmailResponseBeanBuilder setFailedEmail(ArrayList<EmailStatusBean> failedEmail) {
        this.failedEmail = failedEmail;
        return this;
    }

    public EmailResponseBean createEmailResponseBean() {
        return new EmailResponseBean(failedEmail);
    }
}