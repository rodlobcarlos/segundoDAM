package repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Prueba;

@Repository
public interface PruebaRepository extends JpaRepository<Prueba, Long> {

	List<Prueba> findAll();

	Optional<Prueba> findById(Long id);
	
	Prueba findByNombre(String nombre);
	
	Prueba findPruebaByEstadio(String estadio);
}
