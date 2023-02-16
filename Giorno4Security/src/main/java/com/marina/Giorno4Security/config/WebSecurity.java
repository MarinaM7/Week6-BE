package com.marina.Giorno4Security.config;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.marina.Giorno4Security.entities.Role;
import com.marina.Giorno4Security.entities.User;
import com.marina.Giorno4Security.services.DaoService;


@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	private DaoService dao;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
	/*
	 * gestisci le autorizzazioni
	 * permetti l'accesso a / a tutti
	 * mentre a tutte le altre imponi autorizzazione e redirect sulla pagina
	 * di login
	 */
	http
		.authorizeRequests()					
			.antMatchers("/")
			.permitAll()
		.anyRequest()
			.authenticated()
		.and()
		.formLogin()
		.and()
		.logout();
}
	
	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
		Optional<User> authUserObj = dao.getUserById(1);
		User authUser = authUserObj.get();
		String role = "PUBBLICO";
		Set<Role> roles = authUser.getRoles();
		
		for( Role r : roles ) {
			if( r.getRole().toString().contains("PRESENTATORE") ) {
				role = "PRESENTATORE";
				break;
			}
		}
		
		auth.inMemoryAuthentication()
			.withUser( authUser.getUsername() ).password( passwordEncoder().encode( authUser.getPassword() ) )
			.roles(role);
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
