package com.cognizant.oauth2login.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Exercise 1: Spring Boot 3 / Spring Security 6 style configuration.
 * WebSecurityConfigurerAdapter was removed in Spring Security 6, so we
 * expose a SecurityFilterChain bean instead.
 */
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/error").permitAll()
                .anyRequest().authenticated()
            )
            .oauth2Login(oauth2 -> oauth2.defaultSuccessUrl("/user", true));

        return http.build();
    }
}
