package com.cassidy.ecommerce.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class SecurityServiceImpl implements SecurityService {
		@Autowired
		private AuthenticationManager authManager;

		@Autowired
		private UserDetailsService userDetailsService;

		private static final Logger logger = LoggerFactory.getLogger(SecurityServiceImpl.class);

		@Override
		public String findLoggedInUsername() {
				Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
				if (userDetails instanceof UserDetails) {
						return ((UserDetails)userDetails).getUsername();
				}
				return null;
		}

		@Override
		public void autoLogin(String username, String password) {
				UserDetails userDetails = userDetailsService.loadUserByUsername(username);
				UsernamePasswordAuthenticationToken userPasswordAuthToken = new UsernamePasswordAuthenticationToken(
								userDetails, password, userDetails.getAuthorities());

				authManager.authenticate(userPasswordAuthToken);

				if (userPasswordAuthToken.isAuthenticated()) {
						SecurityContextHolder.getContext().setAuthentication(userPasswordAuthToken);
						logger.debug(String.format("Auto login %s successfully!", username));
				}
		}
}
