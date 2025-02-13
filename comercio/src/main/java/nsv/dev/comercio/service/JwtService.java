package nsv.dev.comercio.service;

import org.springframework.security.core.userdetails.UserDetails;

import nsv.dev.comercio.model.Usuario;

public interface JwtService {

	public String getToken(UserDetails usuario);

	public String getUsernameFromToken(String token);

	public boolean isTokenValid(String token, Usuario user);
}
