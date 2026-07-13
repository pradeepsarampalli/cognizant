package com.cognizant.jwtauth.security;

import com.cognizant.jwtauth.config.JwtProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.List;
import java.util.Base64;

/**
 * Exercise 3: Issues and validates JWTs using the modern (0.12.x) JJWT builder API.
 */
@Component
public class JwtTokenProvider {

    private final JwtProperties jwtProperties;
    private final SecretKey key;

    @Autowired
    public JwtTokenProvider(JwtProperties jwtProperties) {
        this.jwtProperties = jwtProperties;
        this.key = Keys.hmacShaKeyFor(Base64.getDecoder().decode(jwtProperties.getSecret()));
    }

    public String createToken(String username) {
        Date now = new Date();
        Date validity = new Date(now.getTime() + jwtProperties.getExpirationMs());

        return Jwts.builder()
                .subject(username)
                .issuedAt(now)
                .expiration(validity)
                .signWith(key)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().verifyWith(key).build().parseSignedClaims(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    public Authentication getAuthentication(String token) {
        Claims claims = Jwts.parser().verifyWith(key).build()
                .parseSignedClaims(token)
                .getPayload();

        String username = claims.getSubject();
        return new UsernamePasswordAuthenticationToken(
                username, "", List.of(new SimpleGrantedAuthority("ROLE_USER")));
    }
}
