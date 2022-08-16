package com.cassidy.ecommerce.HomeControler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
		@GetMapping("/")
		public String home(){
				return ("<h1>Welcome to My Ecommerce Site!</h1>");
		}

		@GetMapping("/user")
		public String user(){
				return ("<h1>You are logged in!</h1>");
		}

		@GetMapping("/admin")
		public String admin(){
				return ("<h1>You are logged in as Admin!</h1>");
		}
}
