package com.vendas.api.delivery_api.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.vendas.api.delivery_api.entities.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class TokenConfig {



    @Value("${security.jwt.secret}")
    private String secret;

    public String generateToken(Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        Algorithm algorithm = Algorithm.HMAC256(secret);
 try {

     return JWT.create()
             .withSubject(user.getUsername())
             .withIssuer("Delivery API")
             .withClaim("id", user.getId())
             .withClaim("name", user.getName())
             .withClaim("role", user.getRole().name())
             .withIssuedAt(Instant.now())
             .withExpiresAt(Instant.now().plusSeconds(86400))
             .sign(algorithm);

 }catch (JWTCreationException exception) {
     throw new RuntimeException("Erro ao criar token", exception);
 }

    }

    public String validToken (String token){


            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("Delivery API")
                    .build()
                    .verify(token)
                    .getSubject();


    }


}
