package com.examen.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examen.dto.DtoAgenda;
import com.examen.dto.DtoCalificacion;
import com.examen.dto.DtoEstudiante;
import com.examen.dto.DtoExamen;
import com.examen.dto.DtoExamenFecha;
import com.examen.dto.DtoRespuesta;
import com.examen.entity.Agenda;
import com.examen.entity.Estudiante;
import com.examen.entity.Examen;
import com.examen.entity.Respuesta;
import com.examen.mapper.AgendaMapper;
import com.examen.mapper.EstudianteMapper;
import com.examen.mapper.ExamenMapper;
import com.examen.mapper.RespuestaMapper;
import com.examen.mapper.ValuesMapper;
import com.examen.repository.IAgendaRepository;
import com.examen.repository.IEstudianteRepository;
import com.examen.repository.IExamenRepository;
import com.examen.repository.IRespuestaRepository;

@Service
public class PruebaService implements IPruebaService {

	@Autowired
	private IExamenRepository examenRepository;

	@Autowired
	private IEstudianteRepository estudianteRepository;

	@Autowired
	private EstudianteMapper estudianteMapper;

	@Autowired
	private ExamenMapper examenMapper;

	@Autowired
	private IAgendaRepository agendaRepository;

	@Autowired
	private AgendaMapper agendaMapper;

	@Autowired
	private IRespuestaRepository respuestaRepository;

	@Autowired
	private RespuestaMapper respuestaMapper;

	@Autowired
	private ValuesMapper valuesMapper;

	@Override
	public List<DtoEstudiante> listAllEstudiantes() {
		List<Estudiante> estudiantes = estudianteRepository.findAll();
		final List<DtoEstudiante> responseEstudiantes = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(estudiantes)) {
			estudiantes.stream().forEach(item -> responseEstudiantes.add(estudianteMapper.mapToOuter(item)));
		}
		return responseEstudiantes;
	}

	@Override
	public List<DtoExamen> listAllExamenes() {
		List<Examen> examenes = examenRepository.findAll();
		final List<DtoExamen> responseExamenes = new ArrayList<>();
		if (CollectionUtils.isNotEmpty(examenes)) {
			examenes.stream().forEach(item -> responseExamenes.add(examenMapper.mapToOuter(item)));
		}
		return responseExamenes;
	}

	@Override
	public DtoExamen createExamen(final DtoExamen examen) {
		return examenMapper.mapToOuter(examenRepository.save(examenMapper.mapToInner(examen)));
	}

	@Override
	public DtoEstudiante crearEstudiante(final DtoEstudiante request) {
		return estudianteMapper.mapToOuter(estudianteRepository.save(estudianteMapper.mapToInner(request)));
	}

	@Override
	public DtoEstudiante findEstudianteByZoneId(final String zoneId) {
		if (!zoneId.isEmpty()) {
			return estudianteMapper.mapToOuter(estudianteRepository.findByZoneId(zoneId));
		}
		return null;
	}

	@Override
	public DtoExamen findExamenByZoneId(final String zoneId) {
		if (!zoneId.isEmpty()) {
			return examenMapper.mapToOuter(examenRepository.findByZoneId(zoneId));
		}
		return null;
	}

	@Override
	public DtoAgenda createAgendaExamen(final DtoExamenFecha request) {
		Examen examen = examenRepository.findByZoneId(request.getZoneId());
		Estudiante estudiante = estudianteRepository.findByZoneId(request.getZoneId());
		Agenda agenda = new Agenda();
		agenda.setEstudiante(estudiante);
		agenda.setExamen(examen);
		agenda.setFechaExamen(null);
		Date fecha = null;
		if (!request.getFechaExamen().isEmpty()) {
			try {
				fecha = new SimpleDateFormat("dd/MM/yyyy").parse(request.getFechaExamen());
			} catch (ParseException e) {

			}
		}
		agenda.setFechaExamen(fecha);
		return agendaMapper.mapToOuter(agendaRepository.save(agenda));
	}

	@Override
	public DtoRespuesta responderExamen(final Long id, final DtoRespuesta request) {
		if (request != null) {
			DtoAgenda agenda = agendaMapper.mapToOuter(agendaRepository.findByEstudianteId(id));
			DtoExamen examen = agenda.getExamen();

			Respuesta respuesta = new Respuesta();
			respuesta.setAlumnoId(id);
			respuesta.setRespuestas(valuesMapper.mapToInner(request.getRespuestas()));

			DtoRespuesta response = respuestaMapper.mapToOuter(respuestaRepository.save(respuesta));
			response.setPreguntas(examen.getPreguntas());
			return response;
		}
		return null;
	}

	@Override
	public DtoRespuesta getRespuesta(final Long id) {
		Respuesta respuesta = respuestaRepository.findByAlumnoId(id);
		DtoAgenda agenda = agendaMapper.mapToOuter(agendaRepository.findByEstudianteId(id));
		DtoExamen examen = agenda.getExamen();

		DtoRespuesta response = respuestaMapper.mapToOuter(respuesta);
		response.setPreguntas(examen.getPreguntas());

		return response;
	}

	@Override
	public DtoCalificacion calificarAlumno(final Long id) {
		Respuesta respuesta = respuestaRepository.findByAlumnoId(id);
		DtoAgenda agenda = agendaMapper.mapToOuter(agendaRepository.findByEstudianteId(id));
		DtoExamen examen = agenda.getExamen();

		DtoRespuesta response = respuestaMapper.mapToOuter(respuesta);
		response.setPreguntas(examen.getPreguntas());

		DtoCalificacion calificacion = calificar(response);

		return calificacion;
	}

	private DtoCalificacion calificar(final DtoRespuesta response) {
		DtoCalificacion calificacion = null;
		Integer acierto = 0;
		Integer resultado = 0;
		if (CollectionUtils.isNotEmpty(response.getPreguntas())) {
			calificacion = new DtoCalificacion();
			if (response.getPreguntas().get(0).getRespuesta().equals(response.getRespuestas().getRespuesta_1())) {
				acierto += 1;
				resultado += 20;
			}
			if (response.getPreguntas().get(1).getRespuesta().equals(response.getRespuestas().getRespuesta_2())) {
				acierto += 1;
				resultado += 20;
			}
			if (response.getPreguntas().get(2).getRespuesta().equals(response.getRespuestas().getRespuesta_3())) {
				acierto += 1;
				resultado += 20;
			}
			if (response.getPreguntas().get(3).getRespuesta().equals(response.getRespuestas().getRespuesta_4())) {
				acierto += 1;
				resultado += 20;
			}
			if (response.getPreguntas().get(4).getRespuesta().equals(response.getRespuestas().getRespuesta_5())) {
				acierto += 1;
				resultado += 20;
			}
			calificacion.setAciertos(acierto);
			calificacion.setCalificacion(resultado);
		}
		return calificacion;
	}

}
