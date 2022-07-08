package com.examen.controller;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.examen.dto.DtoAgenda;
import com.examen.dto.DtoCalificacion;
import com.examen.dto.DtoEstudiante;
import com.examen.dto.DtoExamen;
import com.examen.dto.DtoExamenFecha;
import com.examen.dto.DtoRespuesta;
import com.examen.service.IPruebaService;
import com.examen.util.Message;

@Controller
@RequestMapping("/controlador")
public class PruebaControlador implements IPruebaControlador {

	@Autowired
	private IPruebaService pruebaService;

	@GetMapping("/estudiantes")
	@Override
	public ResponseEntity<List<DtoEstudiante>> listAllEstudiantes() {
		List<DtoEstudiante> estudiantes = pruebaService.listAllEstudiantes();
		if (CollectionUtils.isNotEmpty(estudiantes)) {
			return ResponseEntity.ok(estudiantes);
		}
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/examenes")
	@Override
	public ResponseEntity<List<DtoExamen>> listAllExamenes() {
		List<DtoExamen> examenes = pruebaService.listAllExamenes();
		if (CollectionUtils.isNotEmpty(examenes)) {
			return ResponseEntity.ok(examenes);
		}
		return ResponseEntity.noContent().build();
	}

	@PostMapping("/crearExamen")
	@Override
	public ResponseEntity<?> createExamen(@RequestBody final DtoExamen request) {
		DtoExamen examen = null;
		if (request != null) {
			examen = pruebaService.createExamen(request);
		}
		if (examen != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(examen);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new Message("Error al crear el examen", 400));
	}

	@GetMapping("/examen/{zoneId}")
	@Override
	public ResponseEntity<DtoExamen> findExamenByZoneId(@PathVariable(name = "zoneId") final String zoneId) {
		DtoExamen examen = null;
		if (!zoneId.isEmpty()) {
			examen = pruebaService.findExamenByZoneId(zoneId);
			return ResponseEntity.ok(examen);
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping("/crearEstudiante")
	@Override
	public ResponseEntity<DtoEstudiante> crearEstudiante(@RequestBody final DtoEstudiante request) {
		DtoEstudiante estudiante = null;
		if (request != null) {
			estudiante = pruebaService.crearEstudiante(request);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(estudiante);
	}

	@GetMapping("/estudiante/{zoneId}")
	@Override
	public ResponseEntity<DtoEstudiante> findEstudianteByZoneId(@PathVariable(name = "zoneId") final String zoneId) {
		DtoEstudiante estudiante = null;
		if (!zoneId.isEmpty()) {
			estudiante = pruebaService.findEstudianteByZoneId(zoneId);
			return ResponseEntity.ok(estudiante);
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping("/fechaExamen")
	@Override
	public ResponseEntity<?> definirFechaExamen(@RequestBody final DtoExamenFecha request) {
		DtoAgenda agenda = null;
		if (request != null) {
			if (request.getZoneId() == null || request.getZoneId().equals("")
					|| request.getZoneId().equals(" ")) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body(new Message("ZonID no debe ser nulo o vacio", 404));
			}
			agenda = pruebaService.createAgendaExamen(request);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(agenda);
	}

	@PostMapping("/responderExamen/{id}")
	@Override
	public ResponseEntity<?> responderExamen(@PathVariable(name = "id") final Long id,
			@RequestBody final DtoRespuesta request) {
		DtoRespuesta response = pruebaService.responderExamen(id, request);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping("/getRespuesta/{id}")
	@Override
	public ResponseEntity<?> getRespuesta(@PathVariable(name = "id") final Long id) {
		DtoRespuesta response = pruebaService.getRespuesta(id);
		if (response != null) {
			return ResponseEntity.ok(response);
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/getCalificarEstudiante/{id}")
	@Override
	public ResponseEntity<?> calificarAlumno(@PathVariable(name = "id") final Long id) {
		DtoCalificacion response = pruebaService.calificarAlumno(id);
		if (response != null) {
			return ResponseEntity.ok(response);
		}
		return ResponseEntity.notFound().build();
	}



}