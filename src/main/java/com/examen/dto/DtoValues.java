package com.examen.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(Include.NON_NULL)
public class DtoValues {

	private static final long serialVersionUID = 1L;

	private String respuesta_1;
	private String respuesta_2;
	private String respuesta_3;
	private String respuesta_4;
	private String respuesta_5;

}
