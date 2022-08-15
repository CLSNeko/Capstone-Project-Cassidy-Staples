package com.cassidy.ecommerce.User_roles;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class User_roles {
		private @Setter int userId;
		private @Setter int roleId;
}
