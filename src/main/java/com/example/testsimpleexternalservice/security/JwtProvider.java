package com.example.testsimpleexternalservice.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {

    @Value("${jwt.expiration}")
    private Long expiration;

    @Value("${jwt.secret}")
    private String secret;

    public String createToken(String subject) {
        return JWT
                .create()
                .withSubject(subject)
                .withExpiresAt(new Date(System.currentTimeMillis() + expiration * 1000))
                .sign(Algorithm.HMAC256(secret));
    }

    public String getSubjectFromToken(String token) {
        return JWT
                .require(Algorithm.HMAC256(secret))
                .build()
                .verify(token)
                .getSubject();
    }

}