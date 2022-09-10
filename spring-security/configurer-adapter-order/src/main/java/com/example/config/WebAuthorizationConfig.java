package com.example.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// If this comes later /api/web is never permitAll, because other SecurityFilterChain gets picked first
// Because it first matches on path then on the order of filter chains
@Order(SecurityProperties.BASIC_AUTH_ORDER - 50)
@Configuration
public class WebAuthorizationConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/api/web");

        http.httpBasic();

        http.authorizeRequests()
                .anyRequest()
                .permitAll();
    }

}
