package ru.itis.chats.token;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.stereotype.Component;
import ru.itis.chats.model.user.User;

import java.util.UUID;

@Component
public class Jwt {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.prefix}")
    private String prefix;


    public String getTokenAsString(User user) {
        return prefix + " " + Jwts.builder()
                .claim("role", user.getUserRole().toString())
                .claim("email", user.getEmail())
                .setSubject(user.getId().toString())
                .setId(UUID.randomUUID().toString())
                .signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
    }

/*    public boolean validUserAndToken(String token) {
        Claims body;

        try {
            body = Jwts.parser()
                    .setSigningKey(jwtSecret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            throw new AuthenticationServiceException("Invalid token");
        }


    }*/
}
