package com.examen.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_preguntas")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pregunta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String pregunta;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "opcion_id")
	private Opcion opcion;
	private String respuesta;

}

