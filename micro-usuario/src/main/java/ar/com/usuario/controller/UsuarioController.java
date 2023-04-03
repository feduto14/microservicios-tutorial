package ar.com.usuario.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.usuario.entity.Usuario;
import ar.com.usuario.models.Carro;
import ar.com.usuario.models.Moto;
import ar.com.usuario.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService service;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> listarUsuarios () {
		List<Usuario> usuarios = service.getAll();
		
		if (usuarios.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(usuarios);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> obtenerUsuario (@PathVariable("id") Integer id) {
		Usuario user = service.getUserById(id);
		
		if (user == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(user);
	}
	
	@PostMapping
	public ResponseEntity<Usuario> guardarUsuario (@RequestBody Usuario user) {
		Usuario newUser = service.save(user);
		return ResponseEntity.ok(newUser);
	}
	
	@GetMapping("/carros/{usuarioId}")
	public ResponseEntity<List<Carro>> listarCarros (@PathVariable("usuarioId") Integer id) {
		Usuario usuario = service.getUserById(id);
		if (usuario == null) {
			return ResponseEntity.notFound().build();
		}
		
		List<Carro> listaCarros = service.getCarros(id);
		return ResponseEntity.ok(listaCarros);
	}
	
	@GetMapping("/motos/{usuarioId}")
	public ResponseEntity<List<Moto>> listarMotos (@PathVariable("usuarioId") Integer id) {
		Usuario usuario = service.getUserById(id);
		if (usuario == null) {
			return ResponseEntity.notFound().build();
		}
		
		List<Moto> listaMotos = service.getMotos(id);
		return ResponseEntity.ok(listaMotos);
	}
	
	@PostMapping("/carro/{usuarioId}")
	public ResponseEntity<Carro> guardarCarro (@PathVariable("usuarioId") Integer id, @RequestBody Carro carro) {
		Carro nuevoCarro = service.saveCarro(id, carro);
		return ResponseEntity.ok(nuevoCarro);
	}
	
	@PostMapping("/moto/{usuarioId}")
	public ResponseEntity<Moto> guardarMoto (@PathVariable("usuarioId") Integer id, @RequestBody Moto moto) {
		Moto nuevaMoto = service.saveMoto(id, moto);
		return ResponseEntity.ok(nuevaMoto);
	}
	
	
	@GetMapping("/todos/{usuarioId}")
	public ResponseEntity<Map<String,Object>> listarTodosLosVehiculos (@PathVariable("usuarioId") Integer id) {
		Map<String,Object> resultado = service.getUsuarioAndVehiculos(id);
		return ResponseEntity.ok(resultado);
	}

}
