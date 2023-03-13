package com.example.blogapi.security.jwt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class JWTServiceTest {

    private JWTService jwtService = new JWTService();

    @Test
    void canCreateJWTFromUserID(){
        var userId = 1112;
        var jwt = jwtService.createJWT(userId);
        assertEquals("aaa", jwt);
    }

//    @Test
//    void canVerifyJWT() {
//        var jwt = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMTEyIn0.OXtVbtIYFMSiIkraopI7Pu5iWJRNPyBX1Oa7kFffAKc";
//        var userId = jwtService.getUser
//    }

}
