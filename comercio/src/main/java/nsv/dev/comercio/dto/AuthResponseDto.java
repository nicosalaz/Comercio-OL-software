package nsv.dev.comercio.dto;

import nsv.dev.comercio.model.Usuario;

public class AuthResponseDto {
	private Usuario usuario;
	private String token;
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}	
}
