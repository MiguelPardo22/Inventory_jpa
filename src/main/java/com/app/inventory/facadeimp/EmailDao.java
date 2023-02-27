package com.app.inventory.facadeimp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailDao {

	@Autowired
	JavaMailSender javamail;
	
	public void sendListEmail(String from, String to, String subject, String body) {
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();		
		
		mailMessage.setFrom(from);
		mailMessage.setTo(to);
		mailMessage.setSubject(subject);
		mailMessage.setText(body);
		
		javamail.send(mailMessage);
		
	}

	
	
	
	
}
