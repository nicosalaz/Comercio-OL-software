package nsv.dev.comercio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import nsv.dev.comercio.dto.crearActualizarComercianteDto;
import nsv.dev.comercio.model.Comerciante;
import nsv.dev.comercio.model.Municipio;
import nsv.dev.comercio.persistence.ComercianteRepository;
import nsv.dev.comercio.persistence.MunicipioRepository;

@Service
public class ComercianteServiceImpl implements ComercianteService {
	@Autowired
	private ComercianteRepository comercianteRepository;
	@Autowired
	private MunicipioRepository municipioRepository;
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Comerciante> getAll() {
		return (List<Comerciante>) comercianteRepository.findAll();
	}

	@Override
	public boolean creaComerciante(crearActualizarComercianteDto comerciante) {
		Comerciante comerciante2 = new Comerciante();
		Municipio municipio = null;
		try {
			municipio = municipioRepository.findByMunicipioId(comerciante.getMunicipioId());
			if (municipio != null) {
				Query query = entityManager.createNativeQuery("SELECT sec_comerciantes.NEXTVAL FROM DUAL");
				Long nuevoId = ((Number) query.getSingleResult()).longValue();
				comerciante2.setComercianteId(nuevoId);
				comerciante2.setNombre(comerciante.getNombre());
				comerciante2.setCorreoElectronico(comerciante.getCorreoElectronico());
				comerciante2.setTelefono(comerciante.getTelefono());
				comerciante2.setMunicipio(municipio);
				comerciante2.setEstado(1);
				comerciante2.setUsuarioModifica(comerciante.getUsuarioModifica());
				comercianteRepository.save(comerciante2);
				return true;
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean actualizarComerciante(Long comercianteId, crearActualizarComercianteDto comerciante) {
		Comerciante comerciante2 = null;
		Municipio municipio = null;
		try {
			municipio = municipioRepository.findByMunicipioId(comerciante.getMunicipioId());
			comerciante2 = comercianteRepository.findByComercianteId(comercianteId);
			if (comerciante2 != null && municipio != null) {
				comerciante2.setNombre(comerciante.getNombre());
				comerciante2.setCorreoElectronico(comerciante.getCorreoElectronico());
				comerciante2.setTelefono(comerciante.getTelefono());
				comerciante2.setMunicipio(municipio);
				comerciante2.setEstado(comerciante.getEstado());
				comerciante2.setUsuarioModifica(comerciante.getUsuarioModifica());
				comercianteRepository.save(comerciante2);
				return true;
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean eliminarComerciante(Long comercianteId) {
		Comerciante comerciante = null;
		try {
			comerciante = comercianteRepository.findByComercianteId(comercianteId);
			if (comerciante != null) {
				comercianteRepository.delete(comerciante);
				return true;
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return false;
	}

}
