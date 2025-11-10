package repositoryAct2DOM;

import javax.xml.parsers.DocumentBuilder;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import ModelAct2DOM.Producto;
import utiles.ManejaFicheroPersona;

public class MetodosdomActDOM {
	private static final String rutaResources = "src\\main\\resources\\";
	private static final Logger logger = LogManager.getLogger(ManejaFicheroPersona.class);

	private List<Producto> listaProducto;

	public List<Producto> getListaProducto() {
		return listaProducto;
	}

	public void setListaProducto(List<Producto> listaProducto) {
		this.listaProducto = listaProducto;
	}

	public static String getRutaresources() {
		return rutaResources;
	}

	@Override
	public String toString() {
		return "RepositoryActDOM [listaProducto=" + listaProducto + "]";
	}

	public MetodosdomActDOM(List<Producto> listaProducto) {
		super();
		this.listaProducto = listaProducto;
	}

	// ESCRITURA
	public void escribeProductoEnXML(String nombreFichero, Producto producto) {
		try {
			Document documento = this.construyoObjetoDocumento("Productos.xml");
			Element raiz = documento.getDocumentElement();
			agregaProductoADocumento(documento, raiz, producto);
			escribeDocumentoEnFichero(documento, nombreFichero);
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Element creaElemento(String nombreElemento, String valorElemento, Element padre, Document documento) {
		Element elemento = documento.createElement(nombreElemento);
		Text texto = documento.createTextNode(valorElemento);
		padre.appendChild(elemento);// Se lo asigno a su padre como Hijo
		elemento.appendChild(texto);// Cargo el elemento con el valor
		return elemento;
	}

	private Document construyoObjetoDocumento(String nombreRaiz) throws ParserConfigurationException {
		Document documento = null;
		DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factoria.newDocumentBuilder();
		DOMImplementation implementacion = builder.getDOMImplementation();
		documento = implementacion.createDocument(null, nombreRaiz, null);
		// Primer parámetro uri: si null no está validado por ninguna ruta
		// segundo parámetro: nombre fichero
		// tercer parámetro: document type Por defecto null
		return documento;
	}

	private void escribeDocumentoEnFichero(Document documento, String nombreFichero) throws TransformerException {
		// clases necesarias finalizar la creación del archivo XML
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer;
		transformer = transformerFactory.newTransformer();
		DOMSource source = new DOMSource(documento);
		StreamResult resultado = new StreamResult(new File(this.rutaResources + nombreFichero));
		transformer.transform(source, resultado);
	}

	private void agregaProductoADocumento(Document documento, Element padre, Producto producto) {
		Element nombre = this.creaElemento("nombre", producto.getNombre(), padre, documento);
		Element precio = this.creaElemento("precio", Double.toString(producto.getPrecio()), padre, documento);
		Element stock = this.creaElemento("stock", Integer.toString(producto.getStock()), padre, documento);
		Element enVenta = this.creaElemento("enVenta", Boolean.toString(producto.getEnVenta()), padre, documento);
		padre.setAttribute("id", producto.getId());
	}

	public void escribeProcuctosXML(List<Producto> productos, String rutaFichero) {
		try {
			Document documento = this.construyoObjetoDocumento("empleados");
			for (Producto e : productos) {
				Element elemento = this.creaElemento("empleado", null, documento.getDocumentElement(), documento);
				agregaProductoADocumento(documento, elemento, e);
			}
			escribeDocumentoEnFichero(documento, rutaFichero);
		} catch (ParserConfigurationException e1) {
			logger.error(e1.getMessage());
		} catch (TransformerException e1) {
			logger.error(e1.getMessage());
		}
	}

	//LECTURA
	public List<Producto> leerProductoDesdeXML(String rutaFichero) throws Exception {
		List<Producto> productos = new ArrayList<Producto>();
		// 1. Calcula el dom
		Document doc = getDocumentFromXML(rutaFichero);
		// 2. Obtener todos los nodos con etiqueta empleados
		NodeList nodosProductos = doc.getElementsByTagName("Producto");
		// 3. Recorro la lista de los nodos empleado
		for (int j = 0; j < nodosProductos.getLength(); j++) {
			Node modeloNodo = nodosProductos.item(j);
			if (modeloNodo.getNodeType() == Node.ELEMENT_NODE) {
				Producto e = this.getProductoFromElement((Element) modeloNodo);
				productos.add(e);
			}
		}
		return productos;
	}

	private Document getDocumentFromXML(String nombrefichero) {
		File file = new File(rutaResources + nombrefichero);
		Document documento = null;
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			documento = dBuilder.parse(file);

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return documento;
	}

	private Producto getProductoFromElement(Element elemento) {
		Producto producto = new Producto();
	    String nombre = elemento.getElementsByTagName("Nombre").item(0).getTextContent().trim();
		double precio = Double.parseDouble(elemento.getElementsByTagName("Precio").item(0).getTextContent().trim());
		int stock = Integer.parseInt(elemento.getElementsByTagName("Stock").item(0).getTextContent().trim());
		int id = Integer.parseInt(elemento.getAttribute("id").trim()); // La etiqueta empleado tiene el atributo identificador
		boolean enVenta = Boolean.parseBoolean(elemento.getAttribute("enVenta"));
		producto.setNombre(nombre);
		producto.setPrecio(precio);
		producto.setStock(stock);
		return producto;
	}
}
