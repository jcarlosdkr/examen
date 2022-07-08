package com.examen.mapper;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",
		uses = { ExamenMapper.class, EstudianteMapper.class },
		implementationPackage = "com.examen.mapper.impl")
public interface AgendaExamenMapper {

}
