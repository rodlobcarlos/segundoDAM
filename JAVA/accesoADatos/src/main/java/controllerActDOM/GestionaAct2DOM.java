package controllerActDOM;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ModelAct2DOM.Producto;
import serviceActDOM.ServiceActDOM;

public class GestionaAct2DOM {
	private static final Logger logger = LogManager.getLogger(GestionaAct2DOM.class);


	public static void main(String[] args) {
		
		String ruta = "src\\main\\resources\\productosNoenVenta.json";
		ServiceActDOM service = new ServiceActDOM();
		
		List<Producto> lista;

		try {
			logger.debug(service.productosInferiorNumero(5, "Productos.xml"));
			service.retiraDeVenteProductos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		try {
			lista = service.productosInferiorNumero(5, "Productos.xml");
			service.escribeProductos(lista, ruta);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}