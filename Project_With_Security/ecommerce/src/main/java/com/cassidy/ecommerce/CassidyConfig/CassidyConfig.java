package com.cassidy.ecommerce.CassidyConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class CassidyConfig extends WebSecurityConfigurerAdapter{

		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
				auth.inMemoryAuthentication()
				.withUser("marieInu")
				.password("123")
				.roles("USER")
				.and()
				.withUser("achlys")
				.password("pass123")
				.roles("ADMIN");
		}

		protected void configure(HttpSecurity http) throws Exception {
				http.authorizeRequests()
				.antMatchers("/admin").hasRole("ADMIN")
				.antMatchers("/user").hasAnyRole("ADMIN","USER")
				.antMatchers("/").permitAll()
				.and().formLogin();
				http.csrf().disable();
		}
		@Bean
		public PasswordEncoder getPasswordEncoder() {
				return NoOpPasswordEncoder.getInstance();
		}
}
