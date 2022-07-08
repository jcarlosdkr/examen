package com.examen.repository;

import com.examen.entity.Respuesta;

public interface IRespuestaCustomRepository {

	Respuesta findByAlumnoId(Long id);

}
