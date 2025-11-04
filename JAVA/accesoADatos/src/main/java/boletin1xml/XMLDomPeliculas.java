package boletin1xml;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLDomPeliculas {

	private static final String rutaResources = "src\\main\\resources\\";

	private Pelicula getPeliculaFromElement(Element elemento) {
		Pelicula p = new Pelicula();
		String titulo = elemento.getElementsByTagName("Titulo").item(0).getTextContent();
		int duracion = Integer.parseInt(elemento.getElementsByTagName("Duracion").item(0).getTextContent());
		String genero = elemento.getElementsByTagName("Genero").item(0).getTextContent();
		NodeList actorNodo = ((Element) elemento.getElementsByTagName("Actores").item(0)).getElementsByTagName("Actor");
		p.setTitulo(titulo);
		p.setDuracion(duracion);
		p.setGenero(genero);
		p.setActores(actorNodo);
		return p;
	}

//	private List<String> getActoresFromElement(Element elemento) {
//		List<String> actor = new ArrayList<String>();
//		NODELIST P = ,
//		String titulo = elemento.getElementsByTagName("Titulo").item(0).getTextContent();
//		int duracion = Integer.parseInt(elemento.getElementsByTagName("Duracion").item(0).getTextContent());
//		String genero = elemento.getElementsByTagName("Genero").item(0).getTextContent();
//		NodeList actorNodo = ((Element) elemento.getElementsByTagName("Actores").item(0)).getElementsByTagName("Actor");
//		p.setTitulo(titulo);
//		p.setDuracion(duracion);
//		p.setGenero(genero);
//		p.setActores(actorNodo);
//		return p;
//	}

	public List<Pelicula> leerPeliculasDesdeXML(String rutaFichero) throws Exception {
		List<Pelicula> peliculas = new ArrayList<Pelicula>();
		// 1. Calcula el dom
		Document doc = getDocumentFromXML(rutaFichero);
		// 2. Obtener todos los nodos con etiqueta empleados
		NodeList nodosPeliculas = doc.getElementsByTagName("Pelicula");
		// 3. Recorro la lista de los nodos empleado
		for (int j = 0; j < nodosPeliculas.getLength(); j++) {
			Node modeloNodo = nodosPeliculas.item(j);
			if (modeloNodo.getNodeType() == Node.ELEMENT_NODE) {
				Pelicula p = this.getPeliculaFromElement((Element) modeloNodo);
				peliculas.add(p);
			}
		}
		return peliculas;
	}

	private Document getDocumentFromXML(String nombrefichero) {
		File file = new File(rutaResources + nombrefichero);
		Document documento = null;
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			documento = dBuilder.parse(file);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return documento;
	}
}
