package com.shark.sharkbank.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.function.Function;

@Service
public class TokenService {

    private SecretKey key;
    @Value("${jwt.secret.string}")
    private String JWT_SECRET;
    @Value("${jwt.expiration.time}")
    private Long EXPIRATION_TIME;

    @PostConstruct
    public void init() {
        byte[] keyBytes = JWT_SECRET.getBytes();
        this.key = new SecretKeySpec(keyBytes, "HmacSHA256");
    }

    public String generateToken(String email) {
        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key)
                .compact();
    }
    public String getUsernameFromToken(String token) {
        return extractClaims(token, Claims::getSubject);
    }
    private <T> T extractClaims(String token, Function<Claims, T> claimsTfunction) {
        return claimsTfunction.apply(Jwts.parser().verifyWith(key)
                .build()
                .parseSignedClaims(token)
                .getPayload());
    }
    public boolean isTokenValid(String token, UserDetails userDetails) {
        final   String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpried(token));
    }
    private boolean isTokenExpried(String token) {
        return extractClaims(token, Claims::getExpiration).before(new Date());
    }

}
