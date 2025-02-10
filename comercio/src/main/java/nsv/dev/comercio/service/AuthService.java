package nsv.dev.comercio.service;

import nsv.dev.comercio.dto.AuthResponseDto;
import nsv.dev.comercio.dto.LoginDto;

public interface AuthService {

	public AuthResponseDto login(LoginDto loginDto);

}
