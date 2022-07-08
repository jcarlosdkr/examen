package com.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examen.entity.Respuesta;

public interface IRespuestaRepository extends JpaRepository<Respuesta, Long>, IRespuestaCustomRepository {

}
