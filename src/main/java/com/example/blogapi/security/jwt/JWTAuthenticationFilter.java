package com.example.blogapi.security.jwt;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.authentication.AuthenticationConverter;
import org.springframework.security.web.authentication.AuthenticationFilter;

import javax.naming.AuthenticationException;

public class JWTAuthenticationFilter extends AuthenticationFilter {
    public JWTAuthenticationFilter() {
        super(new JWTAuthenticationManager, new JWTAuthenticationConverter);
    }

    static class JWTAuthenticationManager implements AuthenticationManager {
        @Override
        public org.springframework.security.core.Authentication authenticate(org.springframework.security.core.Authentication authentication) throws org.springframework.security.core.AuthenticationException {
            return null;
        }
    }
    static class JWTAuthenticationConverter implements AuthenticationConverter{

        @Override
        public org.springframework.security.core.Authentication convert(HttpServletRequest request) {
            return null;
        }
    }
}
