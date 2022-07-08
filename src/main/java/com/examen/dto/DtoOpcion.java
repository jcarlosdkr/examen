package com.examen.dto;

import java.io.Serializable;

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
public class DtoOpcion implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private String resp_A;
	private String resp_B;
	private String resp_C;
	private String resp_D;

}
