package com.in28minutes.springboot.web.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.in28minutes.springboot.web.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	List<User> findByRole(String role);
	
}