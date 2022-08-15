package com.cassidy.ecommerce.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name = "User")
public class User {

		@Id
		@Column(name = "userId")
		private @Setter int userId;

		@Column(name = "username")
		private @Setter String username;

		@Column(name = "password")
		private @Setter String password;

		@Column(name = "email")
		private @Setter String email;
}
