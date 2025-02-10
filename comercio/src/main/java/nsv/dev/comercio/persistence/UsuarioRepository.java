package nsv.dev.comercio.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import nsv.dev.comercio.model.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{
	public Usuario findByCorreoElectronico(String correoElectronico);
}
