package controlador;

import servicio.Usuario_servicio;

public class Gestion_streaming {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Usuario_servicio us = new Usuario_servicio();
		System.out.println(us.getRepo().getUsuario());

	}

}
