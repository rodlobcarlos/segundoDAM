package repository;


public class EditorialRepository {

	private Set<Editorial> editoriales;

	public Set<Editorial> getEditorial() {
		return editoriales;
	}

	public void setEditorial(Set<Editorial> editorial) {
		this.editoriales = editorial;
	}

	public EditorialRepository() {
		super();
		this.editoriales = new HashSet<Editorial>();
	}

	public boolean añadirEditorial(Editorial editorial) {
		boolean esAñadido = false;
		if(editoriales.contains(editorial)) {
			System.out.println("El libro ya está añadido.");
		}else {
			editoriales.add(editorial);
			esAñadido = true;
			System.out.println("Libro añadido: " + editorial);		
		}
		return esAñadido;
	}
	
	public boolean actualizarEditorial(Editorial ed) throws LibreriaException {
		boolean esActualizado = true;
		Editorial e = leerEditorial(ed.getCif());
		if(e == null) {
			esActualizado = false;
			throw new LibreriaException("Este libro no existe.");
		} else {
			editoriales.remove(e);
			editoriales.add(e);
		}
		return esActualizado;
	}
	
	public boolean eliminarEditorial(Editorial editorial) throws LibreriaException {
		boolean esEliminado = false;
		if(editoriales.contains(editorial)) {
			editoriales.remove(editorial);
			 esEliminado = true;
		} else {
			throw new LibreriaException("Este libro no exise.");
		}
		return false;
	}
	
	public void consultarEditorial(Editorial editorial) throws LibreriaException {
		boolean esConsultado = false;
		if(editoriales.contains(editorial)) {
			System.out.println(editorial.toString());
			esConsultado = true;
		} else {
			throw new LibreriaException("Este libro no exise.");
		}
	}
	
	public Editorial leerEditorial(String cif) {
		Editorial editorial1 = null;
		boolean encontrado = false;
		Iterator<Editorial> l = editoriales.iterator();
		while(!encontrado && l.hasNext()) {
			Editorial editorial2 = l.next();
			if(editorial2.getCif().equals(cif)) {
				editorial1 = editorial2;
				encontrado = true;
			}
		}
		return editorial1;
	}
	
}
