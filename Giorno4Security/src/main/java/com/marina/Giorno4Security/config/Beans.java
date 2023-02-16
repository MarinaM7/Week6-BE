package com.marina.Giorno4Security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.marina.Giorno4Security.entities.Role;
import com.marina.Giorno4Security.entities.RoleType;
import com.marina.Giorno4Security.entities.User;

@Configuration
public class Beans {

	@Bean
	@Scope("prototype")
	public User user(String fullname, String username, String password) {
		return User.builder()
				.fullname(fullname)
				.username(username)
				.password(password)
				.build();
	}
	
	@Bean
	@Scope("prototype")
	public Role role(RoleType r) {
		return Role.builder()
				.role(r)
				.build();
	}
	
}
