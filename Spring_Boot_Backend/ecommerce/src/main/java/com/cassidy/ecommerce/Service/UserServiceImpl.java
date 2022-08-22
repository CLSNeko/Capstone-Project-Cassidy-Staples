package com.cassidy.ecommerce.Service;

import com.cassidy.ecommerce.Repository.UserRepository;
import com.cassidy.ecommerce.Repository.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
		@Autowired
		private UserRepository userRepository;

		@Autowired
		private RoleRepository roleRepository;
}
