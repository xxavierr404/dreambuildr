package com.xxavierr404.dreambuildr.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final UserDetailsService detailsService;

    @Autowired
    public SecurityConfig(UserDetailsService detailsService) {
        this.detailsService = detailsService;
    }

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeHttpRequests()
                .requestMatchers("/utils/pc-configuration/verify")
                .permitAll()
                .requestMatchers(HttpMethod.GET, "/catalogue/**")
                .permitAll()
                .requestMatchers(HttpMethod.POST, "/auth/register")
                .permitAll()
                .requestMatchers("/cart")
                .authenticated()
                .requestMatchers(HttpMethod.POST, "/catalogue/**")
                .hasAuthority("ADMIN")
                .anyRequest()
                .permitAll()
                .and()
                .formLogin()
                .loginProcessingUrl("/auth/login")
                .and()
                .userDetailsService(detailsService);

        return http.build();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
