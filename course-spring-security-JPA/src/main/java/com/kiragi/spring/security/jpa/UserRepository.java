/**
 * 
 */
package com.kiragi.spring.security.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kiragi.spring.security.jpa.modal.User;
import java.util.List;


/**
 * JPA User repository is creted inoder to make connection with rationbal DB
 */
public interface UserRepository extends JpaRepository<User, Integer>{
	Optional<User> findByUserName(String userName);
}
