package com.examen.mapper;

import org.mapstruct.Mapper;

import com.examen.dto.DtoPregunta;
import com.examen.entity.Pregunta;

@Mapper(componentModel = "spring",
uses = OpcionMapper.class,
implementationPackage = "com.examen.mapper.impl")
public interface PreguntaMapper {

	Pregunta mapToInner(DtoPregunta outer);

	//	@Mapping(target = "respuesta",
	//			ignore = true)
	DtoPregunta mapToOuter(Pregunta inner);

}
