package simulacionBancoAlimentos_manage;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import simulacionBancoAlimentos_model.CentroLogistico;
import simulacionBancoAlimentos_model.Trabajadores;
import simulacionBancoAlimentos_service.BancoAlimento_servicio;

public class GestionaBancoAlimentos {

	private static final Logger logger = LogManager.getLogger(GestionaBancoAlimentos.class);
	private static final String resource = "bancoAlimentos.xml";
	private static final String rutaCSV = "src\\main\\resources\\voluntarios.csv";

	public static void main(String[] args) throws Exception {

		BancoAlimento_servicio servicio = new BancoAlimento_servicio();

		List<Trabajadores> list = servicio.leerTrabajadoresListDesdeXML(resource);
		List<CentroLogistico> list2 = servicio.leerCentroListDesdeXML(resource);


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
