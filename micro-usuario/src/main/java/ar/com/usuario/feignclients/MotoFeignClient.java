package ar.com.usuario.feignclients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import ar.com.usuario.models.Moto;

@FeignClient(name = "micro-moto", path="/moto")
public interface MotoFeignClient {
	
	@PostMapping
	public Moto save (@RequestBody Moto moto);
	
	@GetMapping("/usuario/{usuarioId}")
	public List<Moto> getMotos (@PathVariable("usuarioId") Integer id);

}
