package ar.com.usuario.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import ar.com.usuario.models.Carro;

@FeignClient(name = "micro-carro", path="/carro")
public interface CarroFeignClient {
	
	@PostMapping
	public Carro save (@RequestBody Carro carro);
	
	@GetMapping("/usuario/{usuarioId}")
	public List<Carro> getCarros (@PathVariable("usuarioId") Integer id);

}
