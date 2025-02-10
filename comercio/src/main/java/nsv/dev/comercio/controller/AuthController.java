package nsv.dev.comercio.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nsv.dev.comercio.dto.AuthResponseDto;
import nsv.dev.comercio.dto.LoginDto;
import nsv.dev.comercio.service.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
public class AuthController {
	@Autowired
	private AuthService authService;
	
	@PostMapping("/")
	public ResponseEntity<AuthResponseDto> postMethodName(@RequestBody LoginDto loginDto) {
		return new ResponseEntity<>(authService.login(loginDto),HttpStatus.OK);
	}
	
}
