package com.in28minutes.springboot.web.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration implements WebMvcConfigurer {

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

    protected SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authz) -> authz
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/", "/*todo*/**").hasRole("USER")
                        .requestMatchers(HttpMethod.POST, "/add-todo").hasRole("USER")
                        .anyRequest()
                        .fullyAuthenticated()
                )
                .logout((logout) -> logout.permitAll());

        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user1 = User.builder()
                .username("in28Minutes")
                .password(encoder().encode("123456"))
                .roles("ADMIN","USER")
                .build();
        return new InMemoryUserDetailsManager(user1);
    }
    
    @Bean
    WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring()
                .requestMatchers(new AntPathRequestMatcher("/h2-console/**"));
    }
}