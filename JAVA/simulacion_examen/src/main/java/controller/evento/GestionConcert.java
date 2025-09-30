package controller.evento;

import java.time.LocalDate;

import model.evento.Concierto;
import model.evento.CraftterException;
import model.evento.EstadoEven;
import model.evento.Evento;
import model.evento.Eventos_deportivos;

public class GestionConcert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Evento ed1 = new Eventos_deportivos(1, "futbol", LocalDate.now(), 500, 600, EstadoEven.PROGRAMADO);
		Evento c1 = new Concierto(2, "Concierto 1", LocalDate.now(), 200, 500, EstadoEven.APLAZADO);
		Evento c2 = new Concierto(3, "Concierto 2", LocalDate.now(), 500, 500, EstadoEven.APLAZADO);
		Evento ed2 = new Eventos_deportivos(1, "futbol", LocalDate.now(), 500, 5000, EstadoEven.CANCELADO);
		Evento ed3 = new Eventos_deportivos(1, "futbol", LocalDate.now(), 500, 500, EstadoEven.CANCELADO);


		// 1
		try {
			ed1.modificarEstado(EstadoEven.PENDIENTE);
		} catch (CraftterException e) {
			System.out.println(e.getMessage());
		}
		
		// 2
		System.out.println(c1.getPorcentajeOcupacion(50));
		System.out.println(c1.toString());
		try {
			c1.modificarEstado(EstadoEven.PROGRAMADO);
		} catch (CraftterException e) {
			System.out.println(e.getMessage());
		}
		
		// 3
		System.out.println(c2.getPorcentajeOcupacion(20));
		System.out.println(c2.calcularCosteBase());
		System.out.println(c2.getPorcentajeOcupacion());

		// 4
		System.out.println(ed2.calcularCosteBase());
		System.out.println(ed2.toString());
		
		// 5
		System.out.println(ed3.calcularCosteBase());
		try {
			ed3.modificarEstado(EstadoEven.PROGRAMADO);
		} catch (CraftterException e) {
			System.out.println(e.getMessage());
		}
		
		// 6
		try {
			ed3.modificarEstado(EstadoEven.PENDIENTE);
		} catch (CraftterException e) {
			System.out.println(e.getMessage());
		}

	}

}
