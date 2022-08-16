package com.cassidy.ecommerce.Email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor

public class EmailDetails {
		private String recipient;
		private String msgBody;
		private String subject;
		private String attachment;
}
