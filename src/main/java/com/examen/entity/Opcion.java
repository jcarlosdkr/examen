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
@Table(name = "tbl_opciones")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Opcion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "opcion_id")
	private Long id;
	private String resp_A;
	private String resp_B;
	private String resp_C;
	private String resp_D;

}
