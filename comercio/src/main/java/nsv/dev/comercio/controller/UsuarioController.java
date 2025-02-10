package nsv.dev.comercio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nsv.dev.comercio.model.Usuario;
import nsv.dev.comercio.service.UsuarioService;

@RestController
@RequestMapping(path = "/usuarios")
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;
	@GetMapping("/")
	public ResponseEntity<List<Usuario>> getAllUsuarios() {
		return new ResponseEntity<>(usuarioService.getAll(),HttpStatus.OK);
	}
	
}
