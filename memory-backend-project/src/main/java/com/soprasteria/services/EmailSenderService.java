package com.soprasteria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderService {
	
	
	@Autowired
	JavaMailSender mailSender;
	
	
	/**
	 * Will be called from the controller in response to a post request
	 * 
	 * @param toEmail: the mail of the person to which send the invite
	 */
	public void sendEmail(String toEmail,String linkAccess) {
		
		SimpleMailMessage message = new SimpleMailMessage();
		
		String body = "Ehy! You have been invited to a Memory's Match!\nHere is the link to access\n\n" + linkAccess;
		String subject = "Memory";
		
		//Setting the email
		
		message.setFrom("gorinima@gmail.com"); //My personal mail, that was set to use JavaMailSender
		message.setTo(toEmail);
		message.setText(body);
		message.setSubject(subject);
		mailSender.send(message);
	}
	
}
