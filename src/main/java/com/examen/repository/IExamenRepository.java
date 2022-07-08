package com.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examen.entity.Examen;

@Repository
public interface IExamenRepository extends JpaRepository<Examen, Long>, IExamenCustomRepository {

}
