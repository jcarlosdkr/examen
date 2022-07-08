package com.examen.mapper;

import org.mapstruct.Mapper;

import com.examen.dto.DtoRespuesta;
import com.examen.entity.Respuesta;

@Mapper(componentModel = "spring",
		uses = { ValuesMapper.class, PreguntaMapper.class },
		implementationPackage = "com.examen.mapper.impl")
public interface RespuestaMapper {

	Respuesta mapToInner(DtoRespuesta outer);

	DtoRespuesta mapToOuter(Respuesta inner);
}
