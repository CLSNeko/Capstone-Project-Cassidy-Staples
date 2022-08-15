package com.cassidy.ecommerce.User;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class UserService {

		private final UserRepository userRepository;

		public List<User> getUsers() {
				return userRepository.findAll();
		}
}
