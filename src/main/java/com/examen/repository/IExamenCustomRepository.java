package com.examen.repository;

import com.examen.entity.Examen;

public interface IExamenCustomRepository {

	Examen findByZoneId(String zoneId);

}
