package model;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Entity
@Table(name = "participante")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Participante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idParticipante;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "edad")
	private int edad;

	@Column(name = "pais")
	private String pais;

	@ManyToMany(mappedBy = "participantes")
	private List<Prueba> pruebas;

}
