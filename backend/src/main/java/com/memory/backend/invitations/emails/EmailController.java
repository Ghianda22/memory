package com.memory.backend.invitations.emails;

import com.memory.backend.invitations.emails.data.request.EmailRequestBean;
import com.memory.backend.invitations.emails.data.response.EmailResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/email_invitations")
public class EmailController {
    private final EmailDelegate emailDelegate;

    @Autowired
    public EmailController(EmailDelegate emailDelegate) {
        this.emailDelegate = emailDelegate;
    }

    /**
     * Post method that uses the emailSenderService to send the email to the chosen people,with
     * the respective links.
     *
     * @param emailRequestBean: defined in EmailRequestBean class, so a List of EmailListRequest objects, game id and game name
     * @return a response entity to confirm that everything was right, else error
     */
    @PostMapping("/send_email")
    public ResponseEntity<String> sendEmailInvitations (@RequestBody EmailRequestBean emailRequestBean){
        EmailResponseBean emailResponseBean = emailDelegate.handleEmails(emailRequestBean);
        if(emailResponseBean.getFailedEmail().isEmpty()){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().body(emailResponseBean.toString());
    }

}