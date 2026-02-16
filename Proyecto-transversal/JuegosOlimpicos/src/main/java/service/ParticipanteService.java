package service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import model.JuegosException;
import model.Participante;
import repository.ParticipanteRepository;

@Service
public class ParticipanteService {

	private ParticipanteRepository participanteRepository;

	// Inyección de dependecias
	public ParticipanteService(ParticipanteRepository participanteRepository) {
		super();
		this.participanteRepository = participanteRepository;
	}

	public Participante findByNombre(String nombre) throws JuegosException {
		Participante participante = participanteRepository.findByNombre(nombre);
		if (participante == null) {
			throw new JuegosException("Este nombre no existe.");
		}
			return participante;
	}

	public List<Participante> findAll() {
		return participanteRepository.findAll();
	}

	public Optional<Participante> findById(Long id) throws JuegosException {
		return participanteRepository.findById(id);
	}

	public Participante findParticipanteByPais(String pais) {
		return participanteRepository.findParticipanteByPais(pais);
	}
}
