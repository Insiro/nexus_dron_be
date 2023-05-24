package com.nexus.drone.auth.JWT;

import java.util.Date;
import java.util.Map;

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

    public String createAccessToken(Map<String,Object> user){
        return JWT.create()
                .withSubject(user.get("UUID").toString())
                .withExpiresAt(new Date(System.currentTimeMillis() + JWT_ACCESSTOKEN_VALIDITY * 1000))
                .withClaim("user", user)
                .sign(Algorithm.HMAC512(secret));
    }

    public String createRefreshToken(Map<String,Object> user){
        return JWT.create()
                .withSubject(user.get("UUID").toString())
                .withExpiresAt(new Date(System.currentTimeMillis() + JWT_REFRESHTOKEN_VALIDITY * 1000))
                .withClaim("user",user)
                .sign(Algorithm.HMAC512(secret));
    }

    public boolean isValid(String token){

        try{
            JWT.require(Algorithm.HMAC512(secret)).build().verify(token);
            return true;
        }catch (TokenExpiredException e){
            return false;
        }
    }

    public Map<String,Object> getUserFromToken(String token){
        return JWT.require(Algorithm.HMAC512(secret)).build().verify(token).getClaim("user").asMap();
    }

}
