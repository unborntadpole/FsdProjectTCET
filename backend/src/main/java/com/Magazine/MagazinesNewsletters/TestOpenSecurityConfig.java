package com.Magazine.MagazinesNewsletters;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class TestOpenSecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .cors().and()
                .csrf().disable() // Disable CSRF for testing or APIs
                .authorizeRequests()
                .anyRequest().permitAll() // ← Allow all requests without authentication
                .and()
                .build();
    }
}
