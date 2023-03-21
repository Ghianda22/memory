package com.memory.backend.invitations.emails;

import com.memory.backend.invitations.emails.data.EmailRequestBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
     * @param emailRequestBean: defined in EmailRequestBean class, so a List of strings, and 2 other string fields
     * @return a response entity to confirm that everything was right, else error
     */
    @PostMapping("/send_email")
    public ResponseEntity<Object> sendMailInvites (@RequestBody EmailRequestBean emailRequestBean){
        try {
            emailDelegate.handleEmails(emailRequestBean);
            return new ResponseEntity<>("Invite was send successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
        //return errors or 200
    }

}