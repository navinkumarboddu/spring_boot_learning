package com.java.spring.security.domain;

import com.java.spring.security.security_config.CustomSecurityUser;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
public class Authorities implements GrantedAuthority {

    private Long id;
    private String authority;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private CustomSecurityUser user;

    @Override
    public String getAuthority() {
        return authority;
    }
}
