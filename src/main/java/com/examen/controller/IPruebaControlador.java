package com.examen.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.examen.dto.DtoEstudiante;
import com.examen.dto.DtoExamen;
import com.examen.dto.DtoExamenFecha;
import com.examen.dto.DtoRespuesta;

public interface IPruebaControlador {

	ResponseEntity<List<DtoEstudiante>> listAllEstudiantes();

	ResponseEntity<List<DtoExamen>> listAllExamenes();

	ResponseEntity<?> createExamen(DtoExamen request);

	ResponseEntity<DtoExamen> findExamenByZoneId(String zoneId);

	ResponseEntity<DtoEstudiante> crearEstudiante(DtoEstudiante request);

	ResponseEntity<DtoEstudiante> findEstudianteByZoneId(String zoneId);

	ResponseEntity<?> definirFechaExamen(DtoExamenFecha request);

	ResponseEntity<?> responderExamen(Long id, DtoRespuesta request);

	ResponseEntity<?> getRespuesta(Long id);

	ResponseEntity<?> calificarAlumno(Long id);
}