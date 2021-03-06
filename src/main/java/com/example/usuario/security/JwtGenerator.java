package com.example.usuario.security;

import org.springframework.stereotype.Component;

import com.example.usuario.constants.Constants;
import com.example.usuario.dto.JwtUserTO;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtGenerator {

	public String generate(JwtUserTO jwtUser) {
		
		Claims claims = Jwts.claims().setSubject(jwtUser.getUsername());
		
		claims.put(Constants.USER_ID, String.valueOf(jwtUser.getId()));
		claims.put(Constants.ROLE, jwtUser.getRole());
		
		return  Jwts.builder().setClaims(claims)
				.signWith(SignatureAlgorithm.HS256, Constants.YOUR_SECRET)
				.compact();
	}
}
