package nsv.dev.comercio.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "municipios")
@Entity
public class Municipio {
	@Id
	@Column(name = "municipio_id")
	private Long municipioId;
	@Column(name = "nombre_municipio")
	private String nombreMunicipio;

	public Long getMunicipioId() {
		return municipioId;
	}

	public void setMunicipioId(Long municipioId) {
		this.municipioId = municipioId;
	}

	public String getNombreMunicipio() {
		return nombreMunicipio;
	}

	public void setNombreMunicipio(String nombreMunicipio) {
		this.nombreMunicipio = nombreMunicipio;
	}

	@Override
	public String toString() {
		return "Municipio [municipioId=" + municipioId + ", nombreMunicipio=" + nombreMunicipio + "]";
	}

}
