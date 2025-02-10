package nsv.dev.comercio.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nsv.dev.comercio.model.Comerciante;

@Repository
public interface ComercianteRepository extends CrudRepository<Comerciante, Long>{
	public Comerciante findByComercianteId(Long comercianteId);
}
