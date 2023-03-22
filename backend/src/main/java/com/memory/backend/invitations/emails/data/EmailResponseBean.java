package com.memory.backend.invitations.emails.data;

import java.util.ArrayList;

public final class EmailResponseBean {
    private final ArrayList<EmailStatusBean> failedEmail;

    public EmailResponseBean(ArrayList<EmailStatusBean> failedEmail) {
        this.failedEmail = failedEmail;
    }

    public ArrayList<EmailStatusBean> getFailedEmail() {
        return failedEmail;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (EmailStatusBean email : failedEmail) {
            stringBuilder.append(email.toString());
        }
        return stringBuilder.toString();
    }

//    public EmailResponseBean addFailedEmail(EmailStatusBean emailStatusBean) {
//        ArrayList<EmailStatusBean> updatedList = this.failedEmail;
//        updatedList.add(emailStatusBean);
//        return new EmailResponseBeanBuilder()
//                .setFailedEmail(updatedList)
//                .createEmailResponseBean();
//    }
}
