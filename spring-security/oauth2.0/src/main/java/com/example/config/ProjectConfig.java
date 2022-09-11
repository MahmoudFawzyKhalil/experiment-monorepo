package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.stereotype.Component;

@Component
public class ProjectConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.oauth2Login(c -> {
            c.clientRegistrationRepository(clientRegistrationRepository());
        });

        http.authorizeRequests()
                .anyRequest()
                .authenticated();
    }

    ClientRegistrationRepository clientRegistrationRepository() {
        return new InMemoryClientRegistrationRepository(clientRegistration());
    }

    private ClientRegistration clientRegistration() {
        return ClientRegistration.withRegistrationId("github")
                        .clientId("b60c583aee12b7e2b01e")
                        .clientSecret("78ef352256e6917bc507645bdaff227f84db8c7a")
                        .scope("read:user")
                        .authorizationUri(
                                "https://github.com/login/oauth/authorize")
                        .tokenUri("https://github.com/login/oauth/access_token")
                        .userInfoUri("https://api.github.com/user")
                        .userNameAttributeName("id")
                        .clientName("GitHub")
                        .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
                        .redirectUriTemplate("{baseUrl}/{action}/oauth2/code/{registrationId}")
                        .build();
    }
}
