package com.examen.mapper.impl;

import com.examen.dto.DtoExamen;
import com.examen.dto.DtoExamen.DtoExamenBuilder;
import com.examen.dto.DtoPregunta;
import com.examen.entity.Examen;
import com.examen.entity.Examen.ExamenBuilder;
import com.examen.entity.Pregunta;
import com.examen.mapper.ExamenMapper;
import com.examen.mapper.PreguntaMapper;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-07T22:41:16-0500",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
public class ExamenMapperImpl implements ExamenMapper {

    @Autowired
    private PreguntaMapper preguntaMapper;

    @Override
    public Examen mapToInner(DtoExamen outer) {
        if ( outer == null ) {
            return null;
        }

        ExamenBuilder examen = Examen.builder();

        examen.id( outer.getId() );
        examen.preguntas( dtoPreguntaListToPreguntaList( outer.getPreguntas() ) );
        examen.zoneId( outer.getZoneId() );

        return examen.build();
    }

    @Override
    public DtoExamen mapToOuter(Examen inner) {
        if ( inner == null ) {
            return null;
        }

        DtoExamenBuilder dtoExamen = DtoExamen.builder();

        dtoExamen.id( inner.getId() );
        dtoExamen.preguntas( preguntaListToDtoPreguntaList( inner.getPreguntas() ) );
        dtoExamen.zoneId( inner.getZoneId() );

        return dtoExamen.build();
    }

    protected List<Pregunta> dtoPreguntaListToPreguntaList(List<DtoPregunta> list) {
        if ( list == null ) {
            return null;
        }

        List<Pregunta> list1 = new ArrayList<Pregunta>( list.size() );
        for ( DtoPregunta dtoPregunta : list ) {
            list1.add( preguntaMapper.mapToInner( dtoPregunta ) );
        }

        return list1;
    }

    protected List<DtoPregunta> preguntaListToDtoPreguntaList(List<Pregunta> list) {
        if ( list == null ) {
            return null;
        }

        List<DtoPregunta> list1 = new ArrayList<DtoPregunta>( list.size() );
        for ( Pregunta pregunta : list ) {
            list1.add( preguntaMapper.mapToOuter( pregunta ) );
        }

        return list1;
    }
}
