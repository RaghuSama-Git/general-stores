package com.product.general_stores.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class JwtUtil {

    @Value("${jwt.expiration}")
    private Long expiration;

    //private SecretKey key;
    private final SecretKey secretKey;

    public JwtUtil(SecretKey secretKey) {
        this.secretKey = secretKey;
    }

    public String generateToken(String input) {

        // Generate the JWT token
        String token = Jwts.builder()
                .setSubject(input)
                .setIssuedAt(new Date())
                .setExpiration(Date.from(Instant.now().plus(expiration, ChronoUnit.MINUTES)))
                .signWith(secretKey, SignatureAlgorithm.HS512)
                .compact();
        return token;
    }
}

