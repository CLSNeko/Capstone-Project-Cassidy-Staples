package com.cassidy.ecommerce.Service;

import java.util.HashSet;
import java.util.Set;

import com.cassidy.ecommerce.Model.Role;
import com.cassidy.ecommerce.Model.User;
import com.cassidy.ecommerce.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
		@Autowired
		private UserRepository userRepository;

		@Override
		@Transactional(readOnly = true)
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
				User user = userRepository.findByUsername(username);
				Set grantedAuthorities = new HashSet<>();
				for (Role role : user.getRoles()){
						grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
				}
				return new org.springframework.security.core.userdetails.User(
								user.getUsername(), user.getPassword(), grantedAuthorities);
		}
}
