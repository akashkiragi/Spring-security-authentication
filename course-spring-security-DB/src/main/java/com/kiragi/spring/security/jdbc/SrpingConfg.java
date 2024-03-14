package com.kiragi.spring.security.jdbc;

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

@EnableWebSecurity
public class SrpingConfg extends WebSecurityConfigurerAdapter{
	
	@Autowired
	DataSource dataSource;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/Admin/**").hasRole("ADMIN")
			.antMatchers("/User/**").hasAnyRole("ADMIN","USER")
			.antMatchers("/").permitAll().and().formLogin();
			
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 auth.jdbcAuthentication()
         .dataSource(dataSource());
	}

	private DataSource dataSource() {
		return this.dataSource;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();

	}
}
