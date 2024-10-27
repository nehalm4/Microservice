package com.gateway.util;

import java.security.Key;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtUtil {

	public static String SECRET;

	@SuppressWarnings("static-access")
	JwtUtil(@Value("${security.jwt.secret-key}") String SECRET) {
		this.SECRET = SECRET;
	}

	private Key getSignKey() {
		byte[] keyBytes = Decoders.BASE64.decode(SECRET);
		return Keys.hmacShaKeyFor(keyBytes);
	}

	public void validateToken(final String token) {
		Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token);
	}

}
