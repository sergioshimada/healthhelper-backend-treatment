package br.com.healthhelper.treatment.app.config.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    private final String secret = "$B&E)H@McQfTjWnZr4u7x!z%C*F-JaNd";

    public String validateToken(String token) throws JWTVerificationException{
         Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("auth-api")
                    .build()
                    .verify(token)
                    .getSubject();
    }
}
