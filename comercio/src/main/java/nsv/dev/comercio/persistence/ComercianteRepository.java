package nsv.dev.comercio.persistence;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import nsv.dev.comercio.dto.ComercianteCsvDto;
import nsv.dev.comercio.model.Comerciante;

@Repository
public interface ComercianteRepository extends JpaRepository<Comerciante, Long>{
	public Comerciante findByComercianteId(Long comercianteId);
	public Page<Comerciante> findAll(Pageable pageable);
	@Query(nativeQuery = true, value = "SELECT obtener_comerciantes_activos() FROM dual")
	public List<ComercianteCsvDto> obtener_comerciantes_activos();
}
