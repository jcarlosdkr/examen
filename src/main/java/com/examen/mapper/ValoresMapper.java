package com.examen.mapper;

import org.mapstruct.Mapper;

import com.examen.dto.DtoValores;
import com.examen.entity.Valores;

@Mapper(componentModel = "spring",
		implementationPackage = "com.examen.mapper.impl")
public interface ValoresMapper {

	Valores mapToInner(DtoValores outer);

	DtoValores mapToOuter(Valores inner);

}
