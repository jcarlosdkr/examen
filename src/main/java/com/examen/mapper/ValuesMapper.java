package com.examen.mapper;

import org.mapstruct.Mapper;

import com.examen.dto.DtoValues;
import com.examen.entity.Values;

@Mapper(componentModel = "spring",
		implementationPackage = "com.examen.mapper.impl")
public interface ValuesMapper {

	Values mapToInner(DtoValues outer);

	DtoValues mapToOuter(Values inner);

}
