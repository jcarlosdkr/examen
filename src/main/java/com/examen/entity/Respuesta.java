package com.examen.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_respuestas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Respuesta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long alumnoId;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "pregunta_id")
	private List<Pregunta> preguntas;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "values_id")
	private Values respuestas;

}
