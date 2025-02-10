package nsv.dev.comercio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import nsv.dev.comercio.dto.crearActualizarComercianteDto;
import nsv.dev.comercio.service.ComercianteService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;



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
	public ResponseEntity<Boolean> actualizarComerciante(@PathVariable Long comercianteId, @RequestBody @Valid crearActualizarComercianteDto dto) {
		boolean actualizado = false;
		try {
			actualizado = comercianteService.actualizarComerciante(comercianteId,dto);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return new ResponseEntity<Boolean>(actualizado, HttpStatus.OK);		
	}
	
	@DeleteMapping("/eliminar/{comercianteId}")
	public ResponseEntity<Boolean> eliminarComerciante(@PathVariable Long comercianteId){
		boolean eliminado = false;
		try {
			eliminado = comercianteService.eliminarComerciante(comercianteId);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return new ResponseEntity<Boolean>(eliminado, HttpStatus.OK);
	}
	
}
