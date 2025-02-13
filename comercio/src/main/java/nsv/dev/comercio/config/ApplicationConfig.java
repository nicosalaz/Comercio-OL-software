package nsv.dev.comercio.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import nsv.dev.comercio.model.Usuario;
import nsv.dev.comercio.persistence.UsuarioRepository;

@Configuration
public class ApplicationConfig {
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailService());
		authenticationProvider.setPasswordEncoder(PasswordEncode());
		return authenticationProvider;
	}
	
	
	@Bean
	public PasswordEncoder PasswordEncode() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public UserDetailsService userDetailService() {
		return username -> {
			Usuario usuario = usuarioRepository.findByCorreoElectronico(username);
			return User.
					builder()
					.password(usuario.getClave())
					.username(username)
					.build();
		};
				
	}
}
