package serviceActDOM;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;

import ModelAct2DOM.Producto;
import repositoryAct2DOM.MetodosdomActDOM;
import utiles.ManejaFicheroPersona;

public class ServiceActDOM {

	private MetodosdomActDOM repo;
	private static final Logger logger = LogManager.getLogger(MetodosdomActDOM.class);

	public MetodosdomActDOM getRepo() {
		return repo;
	}

	public void setRepo(MetodosdomActDOM repo) {
		this.repo = repo;
	}

	@Override
	public String toString() {
		return "ServiceActDOM [repo=" + repo + "]";
	}

	public ServiceActDOM() {
		super();
		this.repo = new MetodosdomActDOM(null);
	}

	// Recorre lista y muestra productos menores a una unidad dada
	public List<Producto> productosInferiorNumero(int unidades, String rutaFichero) throws Exception {
		List<Producto> productos = new ArrayList<Producto>();
		List<Producto> todosLosProductos = this.repo.leerProductoDesdeXML(rutaFichero);

		for (Producto p : todosLosProductos) {
			if (p.getStock() < unidades) {
				productos.add(p);
			} else {
				logger.info("El stock no es menor a las unidades");
			}
		}
		return productos;
	}

	// Recorre lista y cambia estado a false, para stock menor a 5
	public void retiraDeVenteProductos() throws Exception {
		List<Producto> lista = productosInferiorNumero(5, "Productos.xml");
		for (Producto p : lista) {
			if (lista != null) {
				p.setEnVenta(false);
				logger.info(p);
			}
		}
	}

	// Escritura de fichero Objeto(lista) a JSON
	public void escribeProductos(List<Producto> productos, String ruta) throws Exception {
		Gson gson = new Gson();
		String json = gson.toJson(productos); // Escribir el JSON en un archivo

		FileWriter writer = null;
		try {
			writer = new FileWriter(ruta);
			writer.write(json);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
