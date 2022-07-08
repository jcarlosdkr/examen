package com.examen.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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
@Table(name = "tbl_agenda")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Agenda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "fecha_examen")
	private Date fechaExamen;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "examen_id")
	private Examen examen;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "estudiante_id")
	private Estudiante estudiante;

}
