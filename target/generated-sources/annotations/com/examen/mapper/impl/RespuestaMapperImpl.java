package com.examen.mapper.impl;

import com.examen.dto.DtoPregunta;
import com.examen.dto.DtoRespuesta;
import com.examen.dto.DtoRespuesta.DtoRespuestaBuilder;
import com.examen.entity.Pregunta;
import com.examen.entity.Respuesta;
import com.examen.entity.Respuesta.RespuestaBuilder;
import com.examen.mapper.PreguntaMapper;
import com.examen.mapper.RespuestaMapper;
import com.examen.mapper.ValuesMapper;
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
public class RespuestaMapperImpl implements RespuestaMapper {

    @Autowired
    private ValuesMapper valuesMapper;
    @Autowired
    private PreguntaMapper preguntaMapper;

    @Override
    public Respuesta mapToInner(DtoRespuesta outer) {
        if ( outer == null ) {
            return null;
        }

        RespuestaBuilder respuesta = Respuesta.builder();

        respuesta.id( outer.getId() );
        respuesta.preguntas( dtoPreguntaListToPreguntaList( outer.getPreguntas() ) );
        respuesta.respuestas( valuesMapper.mapToInner( outer.getRespuestas() ) );

        return respuesta.build();
    }

    @Override
    public DtoRespuesta mapToOuter(Respuesta inner) {
        if ( inner == null ) {
            return null;
        }

        DtoRespuestaBuilder dtoRespuesta = DtoRespuesta.builder();

        dtoRespuesta.id( inner.getId() );
        dtoRespuesta.preguntas( preguntaListToDtoPreguntaList( inner.getPreguntas() ) );
        dtoRespuesta.respuestas( valuesMapper.mapToOuter( inner.getRespuestas() ) );

        return dtoRespuesta.build();
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
