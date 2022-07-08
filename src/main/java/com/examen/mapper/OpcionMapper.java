package com.examen.mapper;

import org.mapstruct.Mapper;

import com.examen.dto.DtoOpcion;
import com.examen.entity.Opcion;

@Mapper(componentModel = "spring",
		implementationPackage = "com.examen.mapper.impl")
public interface OpcionMapper {

	Opcion mapToInner(DtoOpcion outer);

	DtoOpcion mapToOuter(Opcion inner);

}
