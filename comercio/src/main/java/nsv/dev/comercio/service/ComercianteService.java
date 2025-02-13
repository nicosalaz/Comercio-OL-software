package nsv.dev.comercio.service;

import org.springframework.data.domain.Page;

import nsv.dev.comercio.dto.crearActualizarComercianteDto;
import nsv.dev.comercio.model.Comerciante;

public interface ComercianteService {
	public Page<Comerciante> getAll(Integer page, Integer size);
	public Comerciante getByComercianteId(Long comercianteId);
	public boolean creaComerciante(crearActualizarComercianteDto comerciante);
	public boolean actualizarComerciante(Long comercianteId, crearActualizarComercianteDto comerciante);
	public boolean eliminarComerciante(Long comercianteId);
	public String exportarComerciantesCsv();
}
