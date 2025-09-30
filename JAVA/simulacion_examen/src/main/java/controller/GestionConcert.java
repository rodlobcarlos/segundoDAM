package controller;

import java.time.LocalDate;

import model.Concierto;
import model.EstadoEven;
import model.Eventos_deportivos;

public class GestionConcert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Eventos_deportivos ed = new Eventos_deportivos(1, "futbol", LocalDate.now(), 500, 70000, EstadoEven.PROGRAMADO);
		Concierto c = new Concierto(2, "Concierto1", LocalDate.now(), 200, 500, EstadoEven.APLAZADO, null, args, 2000, 5000, 500);

		System.out.println(ed.calcularCosteBase());
		System.out.println();
		
	}

}
