package nsv.dev.comercio.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {

	public String getToken(UserDetails usuario);
}
