package jdbcProyecto.controllers;

import java.time.LocalDate;

import exceptions.MiExcepcion;
import jdbcProyecto.models.Jugador;
import jdbcProyecto.models.Partida;
import jdbcProyecto.models.Resultado;

import jdbcProyecto.services.ServicioJugadores;
import jdbcProyecto.services.ServicioPartidas;

public class GestionaTorneo {

	public static void main(String[] args) {

		Jugador jugador1 = new Jugador(1, "Ana García", "ana.garcia@email.com", 1200);
		Jugador jugador2 = new Jugador(2, "Carlos Ruiz", "carlos.ruiz@email.com", 850);
		Jugador jugador3 = new Jugador(3, "Elena Bosque", "elena.bosque@email.com", 2100);
		Jugador jugador4 = new Jugador(4, "David Miller", "david.miller@email.com", 500);

		// Partida 1: Narrada por Ana
		Partida partida1 = new Partida(101, jugador1, LocalDate.of(2023, 10, 15), Resultado.ALGUNOS);

		// Partida 2: Narrada por Carlos
		Partida partida2 = new Partida(102, jugador2, LocalDate.of(2023, 10, 20), Resultado.NADIE);

		// Partida 3: Narrada por Elena
		Partida partida3 = new Partida(103, jugador3, LocalDate.of(2023, 11, 05), Resultado.TODOS);

		// Partida 4: Narrada por Ana (repite como narradora)
		Partida partida4 = new Partida(104, jugador1, LocalDate.of(2023, 11, 12), Resultado.NADIE);

		// Partida 5: Narrada por David
		Partida partida5 = new Partida(105, jugador4, LocalDate.of(2023, 12, 01), Resultado.ALGUNOS);

		// Partida 6: Narrada por Elena (repite como narradora)
		Partida partida6 = new Partida(106, jugador3, LocalDate.of(2023, 12, 10), Resultado.TODOS);

		try {
			ServicioPartidas servicioPartidas = new ServicioPartidas();
//			servicioPartidas.validaPartida(partida1);
//			servicioPartidas.validaPartida(partida2);
//			servicioPartidas.validaPartida(partida4);
//			servicioPartidas.validaPartida(partida5);
//			
//			servicioPartidas.validaPartida(partida6);
			
			servicioPartidas.borrarPartida(101);
			servicioPartidas.borrarPartida(102);
			servicioPartidas.borrarPartida(103);
			servicioPartidas.borrarPartida(104);
			servicioPartidas.borrarPartida(105);
			servicioPartidas.borrarPartida(106);

		} catch (MiExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			ServicioJugadores servicioJugadores = new ServicioJugadores();
//			servicioJugadores.altaJugador(jugador1);
//			servicioJugadores.altaJugador(jugador2);
//			servicioJugadores.altaJugador(jugador3);
//			servicioJugadores.altaJugador(jugador4);
			
//			servicioJugadores.borrarJugador(1);
//			servicioJugadores.borrarJugador(2);
//			servicioJugadores.borrarJugador(3);
//			servicioJugadores.borrarJugador(4);
			
//			servicioJugadores.obtenerJugadorMayorPuntuacion();

		} catch (MiExcepcion e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
