package nsv.dev.comercio.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class crearActualizarComercianteDto {
	@NotBlank(message = "el nombre es obligatorio")
	private String nombre;
	@NotBlank(message = "el telefono es obligatorio")
	@Size(max = 10, message = "longitud de telefono incorrecta")
	private String telefono;
	@NotBlank(message = "el correo electronico es obligatorio")
	@Email(message = "Ingrese un formato de correo valido")
	private String correoElectronico;
	@NotNull(message = "el municipio es obligatorio")
	@Min(value = 1, message = "municipio no encontrado")
	private Long municipioId;
	@NotNull(message = "el usuario es obligatorio")
	@Min(value = 1, message = "usuario no encontrado")
	private Long usuarioModifica;
	@NotNull(message = "el estado es obligatorio")
	@Min(value = 0, message = "estado puede ser 1 o 0")
	@Max(value = 1, message = "estado puede ser 1 o 0")
	private int estado;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public Long getMunicipioId() {
		return municipioId;
	}

	public void setMunicipioId(Long municipioId) {
		this.municipioId = municipioId;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Long getUsuarioModifica() {
		return usuarioModifica;
	}

	public void setUsuarioModifica(Long usuarioModifica) {
		this.usuarioModifica = usuarioModifica;
	}

}
