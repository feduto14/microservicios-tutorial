package ar.com.carro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.carro.entity.Carro;
import ar.com.carro.service.CarroService;

@RestController
@RequestMapping("/carro")
public class CarroController {
	
	@Autowired
	private CarroService service;
	
	@GetMapping
	public ResponseEntity<List<Carro>> listarCarros () {
		List<Carro> carros = service.getAll();
		
		if (carros.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(carros);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Carro> obtenerUsuario (@PathVariable("id") Integer id) {
		Carro carro = service.getCarroById(id);
		
		if (carro == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(carro);
	}
	
	@PostMapping
	public ResponseEntity<Carro> guardarCarro (@RequestBody Carro carro) {
		Carro newCarro = service.save(carro);
		return ResponseEntity.ok(newCarro);
	}
	
	@GetMapping("/usuario/{userId}")
	public ResponseEntity<List<Carro>> listarCarrosPorUserId (@PathVariable("userId") Integer id) {
		List<Carro> carros = service.getCarrosByUserId(id);
		
		if (carros.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(carros);
	}
	
	

}
