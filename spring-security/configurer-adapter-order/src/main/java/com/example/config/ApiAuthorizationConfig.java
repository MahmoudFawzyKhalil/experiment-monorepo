package com.example.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Order(SecurityProperties.BASIC_AUTH_ORDER - 10)
// If this comes first, the WebAuthorizationConfig never takes place
// I couldn't get it to work really, this always matches the request and the @Order doesn't matter
// These disable the default filter chains /** and /css/** and so on
@Configuration
public class ApiAuthorizationConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/api/**");

        http.httpBasic();

        http.authorizeRequests()
                .anyRequest()
                .authenticated();
    }

}
