package controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import service.ParticipanteService;
import service.PruebaService;

@RestController
public class JuegosController {

	private static final Logger logger = LogManager.getLogger(JuegosController.class);

	@Autowired
	ParticipanteService participanteService;

	@Autowired
	PruebaService pruebaService;
	
	

}
