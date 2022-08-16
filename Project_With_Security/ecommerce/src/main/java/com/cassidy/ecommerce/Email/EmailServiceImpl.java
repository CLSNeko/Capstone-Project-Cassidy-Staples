package com.cassidy.ecommerce.Email;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
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

		public String sendEmailWithAttachment(EmailDetails emailDetails) {
				MimeMessage mimeMessage = javaMailSender.createMimeMessage();
				MimeMessageHelper mimeMessageHelper;
				try {
						mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
						mimeMessageHelper.setFrom(sender);
						mimeMessageHelper.setTo(emailDetails.getRecipient());
						mimeMessageHelper.setText(emailDetails.getMsgBody());
						mimeMessageHelper.setSubject(emailDetails.getSubject());

						FileSystemResource file = new FileSystemResource(new File(emailDetails.getAttachment()));

						mimeMessageHelper.addAttachment(file.getFilename(), file);

						javaMailSender.send(mimeMessage);
						return "Message Sent!";
				} catch (MessagingException e) {
						return "Error While Sending Email!";
				}
		}
}
