package simulacionBancoAlimentos_manage;

// --- Imports ---
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import simulacionBancoAlimentos_model.CentroLogistico;
import simulacionBancoAlimentos_model.Trabajadores;
import simulacionBancoAlimentos_service.BancoAlimento_servicio;

// --- Clase ---
public class GestionaBancoAlimentos {

	// --- Atributos ---
	private static final Logger logger = LogManager.getLogger(GestionaBancoAlimentos.class);
	private static final String resource = "bancoAlimentos.xml"; // solo el nombre del xml añadido en \\resources\\
	private static final String rutaCSV = "src\\main\\resources\\voluntarios.csv"; // ruta completa donde quiero que se cree el archivo .csv

	// --- Main ---
	public static void main(String[] args) throws Exception {

		BancoAlimento_servicio servicio = new BancoAlimento_servicio(); // objeto servicio

		// lista con los datos de los trabajadores
		List<Trabajadores> list = servicio.leerTrabajadoresListDesdeXML(resource); 
		// lista con los datos de los centros logisticos
		List<CentroLogistico> list2 = servicio.leerCentroListDesdeXML(resource);

		// llamadas a los métodos 
		try {
			logger.info(servicio.leerCentroListDesdeXML(resource)); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		logger.info(servicio.tipoTrabajador(Personal.ASALARIADO, list));
		servicio.escribeVoluntarios(list2, rutaCSV);
	}

}
