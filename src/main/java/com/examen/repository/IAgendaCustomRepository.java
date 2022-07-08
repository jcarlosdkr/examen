package com.examen.repository;

import com.examen.entity.Agenda;

public interface IAgendaCustomRepository {

	Agenda findByEstudianteId(Long id);

}
