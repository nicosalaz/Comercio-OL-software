package nsv.dev.comercio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import nsv.dev.comercio.dto.AuthResponseDto;
import nsv.dev.comercio.dto.LoginDto;
import nsv.dev.comercio.model.Usuario;
import nsv.dev.comercio.persistence.UsuarioRepository;

@Service
public class AuthServiceImpl implements AuthService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private JwtService jwtService;
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public AuthResponseDto login(LoginDto loginDto) {
		AuthResponseDto authResponseDto = new AuthResponseDto();
		System.out.println(passwordEncoder.matches(loginDto.getClave(),
				"$2a$10$.xxBTt9mokCJFWx3rk7on.FUTq4kwwm868p5EKngDmzDlF8EqgD82"));
		try {
			authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getCorreo(), loginDto.getClave()));
			Usuario usuario = usuarioRepository.findByCorreoElectronico(loginDto.getCorreo());
			String token = jwtService.getToken(usuario);
			authResponseDto.setToken(token);
			authResponseDto.setUsuario(usuario);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return authResponseDto;
	}
}
