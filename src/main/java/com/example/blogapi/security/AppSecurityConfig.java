package com.example.blogapi.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;

@EnableWebSecurity
public class AppSecurityConfig extends WebSecurityConfiguration {
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable().cors().disable();

        http
                .authorizeHttpRequests().requestMatchers(HttpMethod.POST, "/users**").permitAll()
                .and()
                .authorizeHttpRequests().requestMatchers(HttpMethod.GET, "/articles").permitAll()
                .and().authorizeHttpRequests()
                .anyRequest().authenticated();


    }
}
