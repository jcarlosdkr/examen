package com.examen.mapper.impl;

import com.examen.dto.DtoEstudiante;
import com.examen.dto.DtoEstudiante.DtoEstudianteBuilder;
import com.examen.entity.Estudiante;
import com.examen.entity.Estudiante.EstudianteBuilder;
import com.examen.mapper.EstudianteMapper;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-07T22:41:16-0500",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
public class EstudianteMapperImpl implements EstudianteMapper {

    @Override
    public Estudiante mapToInner(DtoEstudiante outer) {
        if ( outer == null ) {
            return null;
        }

        EstudianteBuilder estudiante = Estudiante.builder();

        estudiante.id( outer.getId() );
        estudiante.nombre( outer.getNombre() );
        estudiante.edad( outer.getEdad() );
        estudiante.ciudad( outer.getCiudad() );
        estudiante.zoneId( outer.getZoneId() );

        return estudiante.build();
    }

    @Override
    public DtoEstudiante mapToOuter(Estudiante inner) {
        if ( inner == null ) {
            return null;
        }

        DtoEstudianteBuilder dtoEstudiante = DtoEstudiante.builder();

        dtoEstudiante.id( inner.getId() );
        dtoEstudiante.nombre( inner.getNombre() );
        dtoEstudiante.edad( inner.getEdad() );
        dtoEstudiante.ciudad( inner.getCiudad() );
        dtoEstudiante.zoneId( inner.getZoneId() );

        return dtoEstudiante.build();
    }
}
