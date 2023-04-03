package ar.com.usuario.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration  //Con esta anotation indicamos que esta clase va a registrar Beans en el I/O Container
public class RestTemplateConfig {
	
	@Bean
	public RestTemplate restTemplate () {
		return new RestTemplate();
	}

}
