package com.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examen.entity.Estudiante;

@Repository
public interface IEstudianteRepository extends JpaRepository<Estudiante, Long>, IEstudianteCustomRepository {

}
