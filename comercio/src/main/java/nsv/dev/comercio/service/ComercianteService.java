package nsv.dev.comercio.service;

import java.util.List;

import nsv.dev.comercio.dto.crearActualizarComercianteDto;
import nsv.dev.comercio.model.Comerciante;

public interface ComercianteService {
	public List<Comerciante> getAll();
	public boolean creaComerciante(crearActualizarComercianteDto comerciante);
	public boolean actualizarComerciante(Long comercianteId, crearActualizarComercianteDto comerciante);
	public boolean eliminarComerciante(Long comercianteId);
}
