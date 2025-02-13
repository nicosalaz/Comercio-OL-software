package nsv.dev.comercio.dto;

import java.util.Date;

public class ComercianteCsvDto {

	private String nombre;
	private String nombre_municipio;
	private String telefono;
	private String correo_electronico;
	private Date fecha_registro;
	private int estado;
	private int cantidad_establecimientos;
	private double ingresos_totales;
	private int cantidad_empleados;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre_municipio() {
		return nombre_municipio;
	}

	public void setNombre_municipio(String nombre_municipio) {
		this.nombre_municipio = nombre_municipio;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo_electronico() {
		return correo_electronico;
	}

	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}

	public Date getFecha_registro() {
		return fecha_registro;
	}

	public void setFecha_registro(Date fecha_registro) {
		this.fecha_registro = fecha_registro;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getCantidad_establecimientos() {
		return cantidad_establecimientos;
	}

	public void setCantidad_establecimientos(int cantidad_establecimientos) {
		this.cantidad_establecimientos = cantidad_establecimientos;
	}

	public double getIngresos_totales() {
		return ingresos_totales;
	}

	public void setIngresos_totales(double ingresos_totales) {
		this.ingresos_totales = ingresos_totales;
	}

	public int getCantidad_empleados() {
		return cantidad_empleados;
	}

	public void setCantidad_empleados(int cantidad_empleados) {
		this.cantidad_empleados = cantidad_empleados;
	}

}
