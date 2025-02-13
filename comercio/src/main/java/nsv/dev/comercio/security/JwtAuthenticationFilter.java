package nsv.dev.comercio.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import nsv.dev.comercio.model.Usuario;
import nsv.dev.comercio.persistence.UsuarioRepository;
import nsv.dev.comercio.service.JwtService;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{
	@Autowired
	private JwtService jwtService;
	@Autowired
	private UsuarioRepository repository;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		final String token = getTokenFromRequest(request); //recuperamos el token
		String usuario;
		if (token == null) {
			filterChain.doFilter(request, response);
			return;
		}
		usuario = jwtService.getUsernameFromToken(token);
		if (usuario != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			Usuario user = repository.findByCorreoElectronico(usuario);
			if (jwtService.isTokenValid(token,user)) {
				UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user, 
						null,
						user.getAuthorities());
				
				authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			}
		}
		filterChain.doFilter(request, response);
	}

	private String getTokenFromRequest(HttpServletRequest request) {
		final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
		if (StringUtils.hasText(authHeader) && authHeader.startsWith("Bearer ")) {
			return authHeader.substring(7);
		}
		return null;
	}

}
