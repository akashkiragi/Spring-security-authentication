package com.kiragi.spring.security.jpa;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kiragi.spring.security.jpa.modal.MyUserDetails;
import com.kiragi.spring.security.jpa.modal.User;


@Service
public class MyUseDetailService implements UserDetailsService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user =  userRepository.findByUserName(username);
		
		user.orElseThrow(()-> new UsernameNotFoundException("User not found for "+ username));
		
		return user.map(MyUserDetails::new).get(); 
	}

}
