package com.java.spring.security.service;

import com.java.spring.security.domain.User;
import com.java.spring.security.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService {

    @Autowired
    private UserRepository userRepository;

    @Secured({"ROLE_ADMIN","ROLE_SUPERUSER"})
    public List<User> getAllUserAccounts(){
        return userRepository.findAll();
    }
}
