package com.java.spring.security.security_config;

import com.java.spring.security.domain.Authorities;
import com.java.spring.security.domain.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collections;
import java.util.Set;

@NoArgsConstructor
public class CustomSecurityUser extends User implements UserDetails {

    public CustomSecurityUser(User user) {
        this.setAuthorities(user.getAuthorities());
        this.setUsername(user.getUsername());
        this.setPassword(user.getPassword());
        this.setId(user.getId());
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
