package com.in28minutes.springboot.web.service;

import com.in28minutes.springboot.web.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}