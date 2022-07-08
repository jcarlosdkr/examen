package com.examen.mapper;

import org.mapstruct.Mapper;

import com.examen.dto.DtoEstudiante;
import com.examen.entity.Estudiante;

@Mapper(componentModel = "spring",
		implementationPackage = "com.examen.mapper.impl")
public interface EstudianteMapper {

	Estudiante mapToInner(DtoEstudiante outer);

	DtoEstudiante mapToOuter(Estudiante inner);

}
