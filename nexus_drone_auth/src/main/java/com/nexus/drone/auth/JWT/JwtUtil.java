package com.nexus.drone.auth.JWT;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;

import org.springframework.beans.factory.annotation.Value;

@Service
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;
    private static final long JWT_ACCESSTOKEN_VALIDITY = 5 * 60 * 60;
    private static final long JWT_REFRESHTOKEN_VALIDITY = 3 * 60 * 60 * 24;

    public String createAccessToken(String uuid){
        return JWT.create()
                .withSubject(uuid)
                .withExpiresAt(new Date(System.currentTimeMillis() + JWT_ACCESSTOKEN_VALIDITY * 1000))
                .withClaim("uuid", uuid)
                .sign(Algorithm.HMAC512(secret));
    }

    public String createRefreshToken(String uuid){
        return JWT.create()
                .withSubject(uuid)
                .withExpiresAt(new Date(System.currentTimeMillis() + JWT_REFRESHTOKEN_VALIDITY * 1000))
                .withClaim("uuid", uuid)
                .sign(Algorithm.HMAC512(secret));
    }

    public boolean AccessisValid(String token){

        try{
            JWT.require(Algorithm.HMAC512(secret)).build().verify(token);
            return true;
        }catch (TokenExpiredException e){
            return false;
        }
    }

    public boolean RefreshisValid(String token){
        try{
            JWT.require(Algorithm.HMAC512(secret)).build().verify(token);
            return true;
        }catch (TokenExpiredException e){
            return false;
        }
    }

    public String getUUIDFromToken(String token){
        return JWT.require(Algorithm.HMAC512(secret)).build().verify(token).getClaim("uuid").asString();
    }

}
