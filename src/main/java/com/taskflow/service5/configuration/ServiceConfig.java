package com.taskflow.service5.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
public class ServiceConfig{

    @Bean
    SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .cors().and()

                .csrf().disable() // Consider enabling and configuring CSRF for browser-based clients
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/meeting/**").permitAll() // Public access

                        .anyRequest().authenticated() // All other requests need authentication
                );

        return httpSecurity.build();
    }
}
