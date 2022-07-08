package com.examen.repository;

import com.examen.entity.Estudiante;

public interface IEstudianteCustomRepository {

	Estudiante findByZoneId(String zoneId);

}
