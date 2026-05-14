// package com.examly.springapp.config;



// import org.springframework.context.annotation.Bean;

// import org.springframework.context.annotation.Configuration;

// import org.springframework.security.config.Customizer;

// import org.springframework.security.config.annotation.web.builders.HttpSecurity;

// import org.springframework.security.web.SecurityFilterChain;



// @Configuration

// public class SecurityFilterConfig {

//     @Bean

//     public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    
//     http
    
//     .csrf().disable()
    
//     .authorizeHttpRequests()
    
//     .requestMatchers("/auth/**").permitAll()
    
//     .anyRequest().authenticated();
    
//     return http.build();
    
//     }

// }