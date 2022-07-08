package com.examen.mapper;

import org.mapstruct.Mapper;

import com.examen.dto.DtoExamen;
import com.examen.entity.Examen;

@Mapper(componentModel = "spring",
		uses = PreguntaMapper.class,
		implementationPackage = "com.examen.mapper.impl")
public interface ExamenMapper {

	Examen mapToInner(DtoExamen outer);

	DtoExamen mapToOuter(Examen inner);

}
