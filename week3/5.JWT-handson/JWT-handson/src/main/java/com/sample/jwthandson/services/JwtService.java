package com.sample.jwthandson.services;


import java.security.Key;
import java.util.Date;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Component;

@Service
public class JwtService {

    // Secret key (must be at least 32 bytes for HS256)
    private static final SecretKey SECRET_KEY =Keys.hmacShaKeyFor("NanduSecretKeyforJWTHandonExercise261".getBytes());

    public String generateToken(String username) {
    	return Jwts.builder().subject(username).issuedAt(new Date())
				.expiration(new Date(System.currentTimeMillis()+1000*60*60))
				.signWith(SECRET_KEY).compact();
    }
}