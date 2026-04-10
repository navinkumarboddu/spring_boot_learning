package com.java.spring.security.service;

import com.java.spring.security.domain.User;
import com.java.spring.security.repositories.UserRepository;
import com.java.spring.security.repositories.UserRepository;
import com.java.spring.security.security_config.CustomSecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found: " + username));

        return new CustomSecurityUser(user);   // ⭐ IMPORTANT
    }
}