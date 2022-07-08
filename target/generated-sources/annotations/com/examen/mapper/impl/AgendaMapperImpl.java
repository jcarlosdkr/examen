package com.examen.mapper.impl;

import com.examen.dto.DtoAgenda;
import com.examen.dto.DtoAgenda.DtoAgendaBuilder;
import com.examen.entity.Agenda;
import com.examen.entity.Agenda.AgendaBuilder;
import com.examen.mapper.AgendaMapper;
import com.examen.mapper.EstudianteMapper;
import com.examen.mapper.ExamenMapper;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-07T22:41:16-0500",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
public class AgendaMapperImpl implements AgendaMapper {

    @Autowired
    private EstudianteMapper estudianteMapper;
    @Autowired
    private ExamenMapper examenMapper;

    @Override
    public Agenda mapToInner(DtoAgenda outer) {
        if ( outer == null ) {
            return null;
        }

        AgendaBuilder agenda = Agenda.builder();

        agenda.id( outer.getId() );
        try {
            if ( outer.getFechaExamen() != null ) {
                agenda.fechaExamen( new SimpleDateFormat().parse( outer.getFechaExamen() ) );
            }
        }
        catch ( ParseException e ) {
            throw new RuntimeException( e );
        }
        agenda.examen( examenMapper.mapToInner( outer.getExamen() ) );
        agenda.estudiante( estudianteMapper.mapToInner( outer.getEstudiante() ) );

        return agenda.build();
    }

    @Override
    public DtoAgenda mapToOuter(Agenda inner) {
        if ( inner == null ) {
            return null;
        }

        DtoAgendaBuilder dtoAgenda = DtoAgenda.builder();

        dtoAgenda.fechaExamen( AgendaMapper.getDate( inner.getFechaExamen() ) );
        dtoAgenda.id( inner.getId() );
        dtoAgenda.examen( examenMapper.mapToOuter( inner.getExamen() ) );
        dtoAgenda.estudiante( estudianteMapper.mapToOuter( inner.getEstudiante() ) );

        return dtoAgenda.build();
    }
}
