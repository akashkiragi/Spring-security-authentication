package com.kiragi.spring.security.jpa;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

@EnableWebSecurity
public class SrpingConfg extends WebSecurityConfigurerAdapter{
	
	@Autowired
	UserDetailsService MyUserDetails;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/Admin/**").hasRole("ADMIN")
			.antMatchers("/User/**").hasAnyRole("ADMIN","USER")
			.antMatchers("/").permitAll().and().formLogin();
			
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 auth.userDetailsService(dataSource());
	}

	private UserDetailsService dataSource() {
		return this.MyUserDetails;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();

	}
}
