package com.examen.service;

import java.util.List;

import com.examen.dto.DtoAgenda;
import com.examen.dto.DtoCalificacion;
import com.examen.dto.DtoEstudiante;
import com.examen.dto.DtoExamen;
import com.examen.dto.DtoExamenFecha;
import com.examen.dto.DtoRespuesta;

public interface IPruebaService {

	List<DtoEstudiante> listAllEstudiantes();

	List<DtoExamen> listAllExamenes();

	DtoExamen createExamen(DtoExamen examen);

	DtoEstudiante crearEstudiante(DtoEstudiante request);

	DtoEstudiante findEstudianteByZoneId(String zoneId);

	DtoExamen findExamenByZoneId(String zoneId);

	DtoAgenda createAgendaExamen(DtoExamenFecha request);

	DtoRespuesta responderExamen(Long id, DtoRespuesta request);

	DtoRespuesta getRespuesta(Long id);

	DtoCalificacion calificarAlumno(Long id);
}
