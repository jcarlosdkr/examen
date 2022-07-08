package com.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examen.entity.Agenda;

@Repository
public interface IAgendaRepository extends JpaRepository<Agenda, Long>, IAgendaCustomRepository {

}
