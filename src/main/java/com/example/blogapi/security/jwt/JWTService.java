package com.example.blogapi.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.stereotype.Service;


import java.util.Date;

@Service
public class JWTService {


    private Algorithm algorithm = Algorithm.HMAC256("SECRETE SIGNING KEY (should be environment or config");
    public String createJWT(Integer userId){
        String token = JWT.create()
                .withSubject(userId.toString())
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7)) /* 7 days */
                .sign(algorithm);
        return token;
    }

//    public Integer getUserIdFromJWT(String JWT){
//        var verifier = JWT.require(algorithm).build;
//        var decodedJWT = verifier.verify(JWT);
//        var subject = decodedJWT.getSubject();
//        return Integer.parseInt(subject);
//    }
}
