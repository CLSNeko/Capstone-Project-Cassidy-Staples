package com.cassidy.ecommerce.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
		
		@Autowired JavaMailSender javaMailSender;
		@Value("$(spring.mail.username)") private String sender;

		public String sendSimpleEmail(EmailDetails emailDetails){
				try {
						SimpleMailMessage mailMessage = new SimpleMailMessage();

						mailMessage.setFrom(sender);
						mailMessage.setTo(emailDetails.getRecipient());
						mailMessage.setText(emailDetails.getMsgBody());
						mailMessage.setSubject(emailDetails.getSubject());

						javaMailSender.send(mailMessage);

						return "Message Sent!";
				} catch (Exception e) {
						return "Error While Sending Mail.";
				}
		}
}
