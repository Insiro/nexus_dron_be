package com.nexus.drone.gateway.JWT;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import org.springframework.beans.factory.annotation.Value;

@Service
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;
    private static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

    public String getUUIDFromToken(String token){
        return JWT.require(Algorithm.HMAC512(secret)).build().verify(token).getClaim("uuid").asString();
    }

}
