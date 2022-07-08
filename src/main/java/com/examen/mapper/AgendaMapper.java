package com.examen.mapper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.examen.dto.DtoAgenda;
import com.examen.entity.Agenda;

@Mapper(componentModel = "spring",
		uses = { EstudianteMapper.class, ExamenMapper.class },
		implementationPackage = "com.examen.mapper.impl")
public interface AgendaMapper {

	Agenda mapToInner(DtoAgenda outer);

	@Mapping(source = "fechaExamen",
			target = "fechaExamen",
			qualifiedByName = "getDate")
	DtoAgenda mapToOuter(Agenda inner);

	@Named("getDate")
	public static String getDate(final Date fecha) {
		String date = null;
		if (fecha != null) {
			DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			date = formatter.format(fecha);
		}
		return date;
	}
}
