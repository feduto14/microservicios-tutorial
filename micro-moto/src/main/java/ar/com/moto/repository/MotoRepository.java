package ar.com.moto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.moto.entity.Moto;

@Repository
public interface MotoRepository extends JpaRepository<Moto, Integer> {
	
	public List<Moto> findByUsuarioId (Integer id);

}
