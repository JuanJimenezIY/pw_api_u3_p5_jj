package com.example.demo.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;

@Component
public class JwtUtils {

	private static final Logger LOG=  LoggerFactory.getLogger(JwtUtils.class);
	public boolean validateJwtToken(String authToken) {
		
		try {
			Jwts.parser().setSigningKey("jwtSemillauyuyugfesybsueyfb561drg65d1rg51drg651drg516516516516516516515661fgh651fghsyuebfysue").parseClaimsJws(authToken);
			return true;
		} catch (Exception e) {
			LOG.error("ERROR",e);
			
		}
		
		return false;
		
		
	}
	
	public String getUserNameFromJwtToken(String token) {
		return Jwts.parser().setSigningKey("jwtSemillauyuyugfesybsueyfb561drg65d1rg51drg651drg516516516516516516515661fgh651fghsyuebfysue").parseClaimsJws(token).getBody().getSubject();
	}
}
