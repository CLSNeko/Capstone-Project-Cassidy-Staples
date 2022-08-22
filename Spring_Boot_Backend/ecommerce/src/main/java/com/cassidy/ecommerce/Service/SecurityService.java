package com.cassidy.ecommerce.Service;

public interface SecurityService {
		String findLoggedInUsername();

		void autoLogin(String username, String password);
}
