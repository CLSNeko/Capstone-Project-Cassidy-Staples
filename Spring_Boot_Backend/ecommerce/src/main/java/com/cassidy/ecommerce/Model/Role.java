package com.cassidy.ecommerce.Model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name = "Role")
public class Role {
		@Id @GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "roleId")
		private int roleId;

		@Column(name = "roleName")
		private String roleName;

		@ManyToMany(mappedBy = "roles")
		private Set users;
}
