package nsv.dev.comercio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nsv.dev.comercio.model.Municipio;
import nsv.dev.comercio.service.MunicipioService;

@RestController
@RequestMapping(path = "/municipios")
public class MunicipioController {
	@Autowired
	private MunicipioService municipioService;

	@GetMapping("/")
	public ResponseEntity<List<Municipio>> getAllMunicipios() {
		return new ResponseEntity<>(municipioService.getAll(), HttpStatus.OK);
	}

}
