package nsv.dev.comercio.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table(name = "comerciantes")
@Entity
public class Comerciante {
	@Id
	@Column(name = "comerciante_id")
	private Long comercianteId;
	@Column(name = "nombre", nullable = false)
	private String nombre;
	@Column(name = "telefono", nullable = false)
	private String telefono;
	@Column(name = "correo_electronico", nullable = false)
	private String correoElectronico;
	@ManyToOne
	@JoinColumn(name = "municipio_id")
	private Municipio municipio;
	@Column(name = "fecha_registro", nullable = true)
	private Date fechaRegistro;
	@Column(name = "estado", nullable = false)
	private int estado;
	@Column(name = "fecha_actualizacion", nullable = true)
	private Date fechaActualizacion;
	@Column(name = "usuario_modifica", nullable = true)
	private int usuarioModifica;

	public Comerciante() {
	}

	public Comerciante(String nombre, String telefono, String correoElectronico, Municipio municipio, int estado) {
		super();
		this.nombre = nombre;
		this.telefono = telefono;
		this.correoElectronico = correoElectronico;
		this.municipio = municipio;
		this.estado = estado;
	}

	public Comerciante(Long comercianteId, String nombre, String telefono, String correoElectronico,
			Municipio municipio, int estado) {
		this.comercianteId = comercianteId;
		this.nombre = nombre;
		this.telefono = telefono;
		this.correoElectronico = correoElectronico;
		this.municipio = municipio;
		this.estado = estado;
	}

	public Long getComercianteId() {
		return comercianteId;
	}

	public void setComercianteId(Long comercianteId) {
		this.comercianteId = comercianteId;
	}

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

	public Municipio getMunicipio() {
		return municipio;
	}

	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	public int getUsuarioModifica() {
		return usuarioModifica;
	}

	public void setUsuarioModifica(int usuarioModifica) {
		this.usuarioModifica = usuarioModifica;
	}

}
