package com.kiragi.spring.security.jpa.modal;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;



public class MyUserDetails implements UserDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6438911592428546720L;
	private String userName;
	private String passWord;
	private String active;
	private List<GrantedAuthority> authorities;
	

	public MyUserDetails(String userName) {
		this.userName = userName;
	}
	public MyUserDetails() {
	}

	public MyUserDetails(User user) {
		
		this.userName = user.getUserName();
		this.passWord = user.getPassword();
		this.active   = user.getActive();
		this.authorities = Arrays.stream( user.getRole().split(","))
								.map(SimpleGrantedAuthority::new)
								.collect(Collectors.toList());
	}
	/*
	 * @Override public Collection<? extends GrantedAuthority> getAuthorities() {
	 * return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")); }
	 * 
	 * @Override public String getPassword() { return "Pass"; }
	 * 
	 * @Override public String getUsername() { return userName; }
	 * 
	 * @Override public boolean isAccountNonExpired() { return true; }
	 * 
	 * @Override public boolean isAccountNonLocked() { return true; }
	 * 
	 * @Override public boolean isCredentialsNonExpired() { return true; }
	 * 
	 * @Override public boolean isEnabled() { return true; }
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	@Override
	public String getPassword() {
		return passWord;
	}
	@Override
	public String getUsername() {
		return userName;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return  true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return active.equalsIgnoreCase("Y");
	}

}
