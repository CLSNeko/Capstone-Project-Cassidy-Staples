package com.cassidy.ecommerce.User;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

		@Bean
		CommandLineRunner commandLineRunner(UserRepository repository){
				return args -> {
						User marie = new User(1, "marieInu", "password123", "marie.robinlace@gmail.com");
						User dave = new User(2, "it_dave", "admin456", "dave.roberts@yahoo.com");

				};
		}
}
