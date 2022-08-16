package com.cassidy.ecommerce.Email;

// Interface
public interface EmailService {

		// Method
		// Send a simple email without attachments
		String sendSimpleEmail(EmailDetails details);

		// Method
		// Send an email with attachments
		String sendEmailWithAttachment(EmailDetails details);
}
