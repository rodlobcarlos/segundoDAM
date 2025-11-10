package serviceActDOM;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;

import ModelAct2DOM.Producto;
import repositoryAct2DOM.RepositoryActDOM;
import utiles.ManejaFicheroPersona;

public class ServiceActDOM {

	private RepositoryActDOM repo;
	private static final Logger logger = LogManager.getLogger(ManejaFicheroPersona.class);

	public RepositoryActDOM getRepo() {
		return repo;
	}

	public void setRepo(RepositoryActDOM repo) {
		this.repo = repo;
	}

	@Override
	public String toString() {
		return "ServiceActDOM [repo=" + repo + "]";
	}

	public ServiceActDOM(RepositoryActDOM repo) {
		super();
		this.repo = repo;
	}

	// Recorre lista y muestra productos menores a una unidad dada
	public List<Producto> productosInferiorNumero(int unidades) {
		List<Producto> productos = new ArrayList<Producto>();

		for (Producto p : productos) {
			if (p.getStock() < unidades) {
				productos.add(p);
			} else {
				logger.info("El stock no es menor a las unidades");
			}
		}
		return productos;
	}

	// Recorre lista y cambia estado a false, para stock menor a 5
	public void retiraDeVenteProductos() {
		List<Producto> lista = productosInferiorNumero(5);
		for (Producto p : lista) {
			if (lista != null) {
				p.setEnVenta(false);
				logger.info(p);
			}
		}
	}

	// Escritura de fichero Objeto(lista) a JSON
	public void escribeProductos(List<Producto> productos, String ruta) {
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
