package com.sample.jwthandson.controllers;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.sample.jwthandson.services.JwtService;

@RestController
public class AuthenticationController {
	@Autowired
	JwtService serv;

	@GetMapping("/authenticate")
	public String authenticate(@RequestHeader("Authorization") String authorizationHeader) {
	    String base64Credentials=authorizationHeader.substring(6);
	    byte[] decodedBytes=Base64.getDecoder().decode(base64Credentials);
	    String credentials=new String(decodedBytes, StandardCharsets.UTF_8);
	    String[] values=credentials.split(":", 2);
	    String username=values[0];
	    return serv.generateToken(username);
	}
}