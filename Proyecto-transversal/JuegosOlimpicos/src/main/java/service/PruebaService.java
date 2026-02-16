package service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import model.JuegosException;
import model.Prueba;
import repository.PruebaRepository;

@Service
public class PruebaService {

	private PruebaRepository pruebaRepository;

	// Inyección de dependencias
	public PruebaService(PruebaRepository pruebaRepository) {
		super();
		this.pruebaRepository = pruebaRepository;
	}

	public List<Prueba> findAll() {
		return pruebaRepository.findAll();
	}

	public Optional<Prueba> findById(Long id) {
		return pruebaRepository.findById(id);
	}

	public Prueba findByNombre(String nombre) {
		return pruebaRepository.findByNombre(nombre);
	}

	public Prueba findPruebaByEstadio(String estadio) throws JuegosException {
		Prueba prueba = pruebaRepository.findPruebaByEstadio(estadio);
		if (prueba == null) {
			throw new JuegosException("Este estadio no existe.");
		}
		return prueba;
	}
}
