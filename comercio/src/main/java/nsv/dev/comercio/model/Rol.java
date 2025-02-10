package nsv.dev.comercio.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "roles")
@Entity
public class Rol {
	@Id
	@Column(name = "rol_id")
	private int rolId;
	@Column(name = "nombre_rol", nullable = false)
	private String nombreRol;

	public int getRolId() {
		return rolId;
	}

	public void setRolId(int rolId) {
		this.rolId = rolId;
	}

	public String getNombreRol() {
		return nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	@Override
	public String toString() {
		return "Rol [rolId=" + rolId + ", nombreRol=" + nombreRol + "]";
	}

}
