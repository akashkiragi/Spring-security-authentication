package com.kiragi.spring.security.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@SpringBootApplication
public class CourseSpringSecurityJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CourseSpringSecurityJpaApplication.class, args);
	}

}
