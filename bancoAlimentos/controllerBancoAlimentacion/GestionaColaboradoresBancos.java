package controllerBancoAlimentacion;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import modelBancoAlimento.CentroLogistico;
import modelBancoAlimento.TipoPersonal;
import modelBancoAlimento.Trabajadores;
import serviceBancoAlimento.ServiceBancoAlimento;

public class GestionaColaboradoresBancos {

	private static final Logger logger = LogManager.getLogger(GestionaColaboradoresBancos.class);

	public static void main(String[] args) {

		ServiceBancoAlimento service = new ServiceBancoAlimento();
		
		List<CentroLogistico> c = service.leerCentroXML("bancoAlimentos.xml");

		List<Trabajadores> t1 = service.getColaboradoresPorTipo(c, TipoPersonal.VOLUNTARIO);
		
		service.escribePersonas(t1, c, "src\\main\\resources\\voluntarios.csv");
		
		logger.info(c);
	}

}
