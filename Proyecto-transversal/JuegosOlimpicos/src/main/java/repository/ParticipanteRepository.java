package repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Participante;

@Repository
public interface ParticipanteRepository extends JpaRepository<Participante, Long> {

	Participante findByNombre(String nombre);

	List<Participante> findAll();

	Optional<Participante> findById(Long id);
	
	Participante findParticipanteByPais(String pais);

}
