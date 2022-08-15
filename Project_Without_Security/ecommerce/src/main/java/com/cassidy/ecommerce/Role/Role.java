package com.cassidy.ecommerce.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Role {
		private @Setter String roleName;
		private @Setter int roleId;
}
