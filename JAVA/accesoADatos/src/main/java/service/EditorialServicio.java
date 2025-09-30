package service;

import java.util.Comparator;
import java.util.List;

import model.Editorial;
import model.LibreriaException;
import repository.EditorialRepository;

public class EditorialServicio {

	    private EditorialRepository editorialRep;

	    public EditorialServicio() {
	        super();
	        this.editorialRep = new EditorialRepository();
	    }

	    public EditorialRepository getEditorialRep() {
	        return editorialRep;
	    }

	    public void setEditorialRep(EditorialRepository editorialRep) {
	        this.editorialRep = editorialRep;
	    }

	    public void añadirEditorial(Editorial e) {
	    	editorialRep.añadirEditorial(e);
	    }

	    public void actualizarEditorial(Editorial e) {
	        try {
	        	editorialRep.actualizarEditorial(e);
	        } catch (LibreriaException ex) {
	            System.out.println(ex.getMessage());
	        }
	    }

	    public void consultarEditorial(Editorial e) {
	        try {
	            editorialRep.consultarEditorial(e);
	        } catch (LibreriaException ex) {
	            System.out.println(ex.getMessage());
	        }
	    }

	    public void eliminarEditorial(Editorial e) {
	        try {
	            editorialRep.eliminarEditorial(e);
	        } catch (LibreriaException ex) {
	            System.out.println(ex.getMessage());
	        }
	    }

	    public void leerEditorial(String CIF) {
	            editorialRep.leerEditorial(CIF);
	    }
	    
	    public List<Editorial> ordenarEditorialEmail() {
	    	//Comparator c = new Comparator();
	    	this.editorialRep.getEditorial().sort(null);
			return null;
	    }

}

