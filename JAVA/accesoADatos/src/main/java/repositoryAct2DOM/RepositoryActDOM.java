package repositoryAct2DOM;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import ModelAct2DOM.Producto;

public class RepositoryActDOM {
	private static final String rutaResources = "src\\main\\resources";

	private RepositoryActDOM repo;

	public RepositoryActDOM getRepo() {
		return repo;
	}

	public void setRepo(RepositoryActDOM repo) {
		this.repo = repo;
	}

	@Override
	public String toString() {
		return "RepositoryActDOM [repo=" + repo + "]";
	}

	public RepositoryActDOM(RepositoryActDOM repo) {
		super();
		this.repo = repo;
	}
	
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
	

}
