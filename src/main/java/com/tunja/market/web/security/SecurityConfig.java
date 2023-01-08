package com.tunja.market.web.security;

import com.tunja.market.domain.service.AdminUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Autowired
    private AdminUserDetailService adminUserDetailService;


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(adminUserDetailService);
        AuthenticationManager authenticationManager = authenticationManagerBuilder.build();

        http.authorizeRequests().anyRequest().authenticated().and().formLogin().and().httpBasic().and().authenticationManager(authenticationManager);
        return http.build();
    }




}
