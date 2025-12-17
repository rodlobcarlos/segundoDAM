package controlador;

import modelo.PlanActivo;
import modelo.Preferencias;
import modelo.Usuario;
import servicio.ServicioUsuario;

public class GestionaUsuarios {

	public static void main(String[] args) {

		ServicioUsuario servicioUsuario = new ServicioUsuario();
		servicioUsuario.obtenerUsuarios();
		servicioUsuario.buscarId("usr002");
		
		Preferencias preferencias = new Preferencias(false, "ES", false, false);
		
		Usuario usuario = new Usuario("user041", "usernameX", "user@email.com", PlanActivo.FREE, 
				"movil", preferencias);
		servicioUsuario.nuevoUsuario(usuario);
		
		servicioUsuario.eliminarPorDisposiivo("android12");
	}

}
