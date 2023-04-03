package ar.com.carro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.carro.entity.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Integer> {
	
	public List<Carro> findByUsuarioId (Integer id);

}
