package nsv.dev.comercio.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import nsv.dev.comercio.dto.crearActualizarComercianteDto;
import nsv.dev.comercio.model.Comerciante;
import nsv.dev.comercio.service.ComercianteService;


@RestController
@RequestMapping(path = "/comerciantes")
public class ComercianteController {
	@Autowired
	private ComercianteService comercianteService;

	@PostMapping("/crear")
	public ResponseEntity<Boolean> crearComerciante(@RequestBody @Valid crearActualizarComercianteDto comerciante) {
		boolean creado = false;
		try {
			creado = comercianteService.creaComerciante(comerciante);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return new ResponseEntity<Boolean>(creado, HttpStatus.CREATED);
	}

	@PutMapping("/actualizar/{comercianteId}")
	public ResponseEntity<Boolean> actualizarComerciante(@PathVariable Long comercianteId,
			@RequestBody @Valid crearActualizarComercianteDto dto) {
		boolean actualizado = false;
		try {
			actualizado = comercianteService.actualizarComerciante(comercianteId, dto);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return new ResponseEntity<Boolean>(actualizado, HttpStatus.OK);
	}

	@DeleteMapping("/eliminar/{comercianteId}")
	public ResponseEntity<Boolean> eliminarComerciante(@PathVariable Long comercianteId) {
		boolean eliminado = false;
		try {
			eliminado = comercianteService.eliminarComerciante(comercianteId);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return new ResponseEntity<Boolean>(eliminado, HttpStatus.OK);
	}

	@GetMapping(value = {"/","/{page}/{size}"})
	public Page<Comerciante> getMethodName(@PathVariable(required = false) Optional<Integer> page,
			@PathVariable(required = false) Optional<Integer> size) {
		Integer pageValue = page.isPresent() == false ? 0:page.get();
		Integer sizeValue = size.isPresent() == false ? 5:size.get();
		return comercianteService.getAll(pageValue, sizeValue);
	}
	
	@GetMapping("/{comercianteId}")
	public ResponseEntity<Comerciante> getComercianteByComercianteId(@PathVariable(required = true) Long comercianteId) {
		Comerciante comerciante = null;
		HttpStatus httpStatus = HttpStatus.OK;
		try {
			comerciante = comercianteService.getByComercianteId(comercianteId);
			httpStatus = comerciante == null ? HttpStatus.CONFLICT : httpStatus.OK;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Comerciante>(comerciante,httpStatus);
	}
	
	@GetMapping("/exportar")
	public String exportarCsv() {
		return comercianteService.exportarComerciantesCsv();
	}
	
	

}
