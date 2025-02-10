package nsv.dev.comercio.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtServiceImpl implements JwtService{
	
	private static final String SECRET_KEY = "n1c0l4s10*.";

	@Override
	public String getToken(UserDetails usuario) {
		return getToken(new HashMap<>(),usuario);
	}

	private String getToken(Map<String, Object> extraClaims, UserDetails usuario) {
		return Jwts
				.builder()
				.setClaims(extraClaims)
				.setSubject(usuario.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+1000*60))
				.signWith(getKey(),SignatureAlgorithm.HS256)
				.compact();
	}

	private Key getKey() {
		byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
		return Keys.hmacShaKeyFor(keyBytes);
	}

}
