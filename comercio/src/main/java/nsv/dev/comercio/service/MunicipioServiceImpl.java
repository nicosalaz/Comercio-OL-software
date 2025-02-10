package nsv.dev.comercio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nsv.dev.comercio.model.Municipio;
import nsv.dev.comercio.persistence.MunicipioRepository;
@Service
public class MunicipioServiceImpl implements MunicipioService{
	@Autowired
	private MunicipioRepository municipioRepository;
	@Override
	public List<Municipio> getAll() {
		return municipioRepository.findAll();
	}

}
