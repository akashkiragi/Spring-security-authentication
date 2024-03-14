package com.kiragi.spring.security.jpa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {
	
	@GetMapping("/")
	public String defaultMethod() {
		return "<h2>Your Using the method</h2>";
	}
	
	@GetMapping("/Admin/{id}")
	public String adminMethod(@PathVariable String id) {
		String string = "User is logged in as Admin Role"+id+" Please Continue";
		return "<h2>"+string+"</h2>";
	}

	@GetMapping("/User/{id}")
	public String userMethod(@PathVariable String id) {
		String string = "User is logged in as User Role  "+id+" Please Continue";
		return "<h2>"+string+"</h2>";
		
	}
}
