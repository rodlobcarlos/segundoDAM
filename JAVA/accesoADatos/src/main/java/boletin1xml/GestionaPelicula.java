package boletin1xml;

public class GestionaPelicula {

	public static void main(String[] args) {

		XMLDomPeliculas p = new XMLDomPeliculas();
		try {
			System.out.println(p.leerPeliculasDesdeXML("peliculas.xml"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
