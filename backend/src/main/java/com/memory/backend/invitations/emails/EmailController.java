package com.memory.backend.invitations.emails;

import com.memory.backend.invitations.emails.data.EmailRequestBean;
import com.memory.backend.invitations.emails.data.EmailResponseBean;
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
    public ResponseEntity<String> sendEmailInvitations (@RequestBody EmailRequestBean emailRequestBean){
        EmailResponseBean emailResponseBean = emailDelegate.handleEmails(emailRequestBean);
        if(emailResponseBean.getFailedEmail().isEmpty()){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.badRequest().body(emailResponseBean.toString());
    }

}

/**
 * opt 1: itero nel controller, chiamo il delegate x volte. Il delegate mi ritorna un emailResponse. Il body della response entity è un array delle emailresponse del delegate
 * opt 2: itero nel delegate, chiamo il delegate 1 volta. Il delegate mi ritorna la risposta da inviare e non lancia eccezioni.
 * EmailResponse è un oggetto con 1 solo campo come lista di EmailStatus. EmailStatus ha indirizzo mail e messaggio di stato
 * */