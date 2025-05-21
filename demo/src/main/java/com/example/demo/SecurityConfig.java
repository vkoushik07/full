package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/my/hello", "/h2-console/**","/departments/**").permitAll()  // Allow these paths
                .anyRequest().authenticated()  // Require authentication for others
            )
            .formLogin() // default login form
            .and()
            .csrf(csrf -> csrf.disable()) // Disable CSRF for H2 and ease of testing
            .headers(headers -> headers.frameOptions().disable()); // Allow H2 Console

        return http.build();
    }
}
