package nsv.dev.comercio.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import nsv.dev.comercio.model.Municipio;

public interface MunicipioRepository extends JpaRepository<Municipio, Long> {
	public Municipio findByMunicipioId(Long municipioId);
}
