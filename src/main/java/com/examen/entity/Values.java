package com.examen.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_values")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Values {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "opcion_id")
	private Long id;
	private String respuesta_1;
	private String respuesta_2;
	private String respuesta_3;
	private String respuesta_4;
	private String respuesta_5;

}
