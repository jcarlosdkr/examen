package com.examen.mapper.impl;

import com.examen.dto.DtoPregunta;
import com.examen.dto.DtoPregunta.DtoPreguntaBuilder;
import com.examen.entity.Pregunta;
import com.examen.entity.Pregunta.PreguntaBuilder;
import com.examen.mapper.OpcionMapper;
import com.examen.mapper.PreguntaMapper;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-07T22:41:16-0500",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
public class PreguntaMapperImpl implements PreguntaMapper {

    @Autowired
    private OpcionMapper opcionMapper;

    @Override
    public Pregunta mapToInner(DtoPregunta outer) {
        if ( outer == null ) {
            return null;
        }

        PreguntaBuilder pregunta = Pregunta.builder();

        pregunta.id( outer.getId() );
        pregunta.pregunta( outer.getPregunta() );
        pregunta.opcion( opcionMapper.mapToInner( outer.getOpcion() ) );
        pregunta.respuesta( outer.getRespuesta() );

        return pregunta.build();
    }

    @Override
    public DtoPregunta mapToOuter(Pregunta inner) {
        if ( inner == null ) {
            return null;
        }

        DtoPreguntaBuilder dtoPregunta = DtoPregunta.builder();

        dtoPregunta.id( inner.getId() );
        dtoPregunta.pregunta( inner.getPregunta() );
        dtoPregunta.opcion( opcionMapper.mapToOuter( inner.getOpcion() ) );
        dtoPregunta.respuesta( inner.getRespuesta() );

        return dtoPregunta.build();
    }
}
