package model;

import java.time.LocalDateTime;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
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
@Table(name = "prueba")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Prueba {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPrueba;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "estadio")
	private String estadio;

	@Column(name = "diaHora")
	private LocalDateTime dia;

	@ManyToMany(mappedBy = "pruebas", cascade = CascadeType.ALL)
	private List<Participante> participantes;

}
