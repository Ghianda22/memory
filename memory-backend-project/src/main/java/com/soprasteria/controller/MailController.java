package com.soprasteria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soprasteria.controller.parameters.EmailSenderParam;
import com.soprasteria.services.EmailSenderService;

@CrossOrigin
@RestController
@RequestMapping("/mail")
public class MailController {
	
	@Autowired
	EmailSenderService emailSenderService;
	
	/**
	 * Post method that uses the emailSenderService to send the email to the chosen people,with
	 * the respective links.
	 * 
	 * @param params: defined in EmailSenderParam class, so a list of strings
	 * @return a response entity to confirm that everything was right, else 404 error
	 */
	@PostMapping("/sendmail") 
	public ResponseEntity<Object> sendMailInvites (@RequestBody EmailSenderParam params){
		for(int i = 0; i < params.getMailList().size(); ++i) {
			try {
				emailSenderService.sendEmail(params.getMailList().get(i), params.getLinkList().get(i));
			} catch (MailException e) {
				return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
			}
			
		}
		return new ResponseEntity<Object>("Invite was send successfully", HttpStatus.OK);
	}

}
