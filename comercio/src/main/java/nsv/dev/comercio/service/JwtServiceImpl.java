package nsv.dev.comercio.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import nsv.dev.comercio.model.Usuario;

@Service
public class JwtServiceImpl implements JwtService{
	
	private static final String SECRET_KEY = "JINVEHFBVWEUHBVNVFE897R8745YBFVHEBFVWUGV8734615R3VUGDSV*";

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
	
	private Claims getAllClaims(String token) {
		return Jwts
				.parserBuilder()
				.setSigningKey(getKey())
				.build()
				.parseClaimsJws(token)
				.getBody();
	}
	
	private Date getExpiracion(String token) {
		return getClaims(token, Claims::getExpiration);
	}
	
	private boolean isTokenExpired(String token) {
		return getExpiracion(token).before(new Date());
	}
	
	public <T> T getClaims(String token, Function<Claims,T> claimsResolver) {
		final Claims claims =  getAllClaims(token);
		return claimsResolver.apply(claims);
	}

	@Override
	public String getUsernameFromToken(String token) {
		return getClaims(token, Claims::getSubject);
	}

	@Override
	public boolean isTokenValid(String token, Usuario user) {
		String username = getUsernameFromToken(token);
		
		return (username.equals(user.getUsername()) && !isTokenExpired(token));
	}

}
