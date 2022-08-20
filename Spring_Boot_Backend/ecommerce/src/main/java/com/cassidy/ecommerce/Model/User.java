package com.cassidy.ecommerce.Model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name = "User")
public class User {

		@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "userId")
		private int userId;

		@Column(name = "username")
		private String username;

		@Column(name = "password")
		private String password;

		@Column(name = "email")
		private String email;

		@ManyToMany
		@JoinTable(name="User_roles",
				   joinColumns = @JoinColumn(name = "userId"),
				   inverseJoinColumns = @JoinColumn(name = "roleId"))
		private Set roles;
}
