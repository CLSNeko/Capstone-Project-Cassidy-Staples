package com.cassidy.ecommerce.Service;

import com.cassidy.ecommerce.Model.User;

public interface UserService {
		void save(User user);

		User findByUsername(String username);
}
