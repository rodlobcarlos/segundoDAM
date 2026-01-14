package hibernate_model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reunion")
public class Reunion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idReunion;
	// Es obligatorio usar la notación @Column(name="nombreCampo")
	// Si las columnas de la tablas se llaman diferentes que los atributos
	// @Column(name="fecha")
	private LocalDateTime fecha;
	// @Column(name="asunto")
	private String asunto;
	// Generamos el constructor sin parámetros y los métodos get/set
}
