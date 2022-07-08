package com.examen.mapper.impl;

import com.examen.dto.DtoValues;
import com.examen.dto.DtoValues.DtoValuesBuilder;
import com.examen.entity.Values;
import com.examen.entity.Values.ValuesBuilder;
import com.examen.mapper.ValuesMapper;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-07T22:41:16-0500",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
public class ValuesMapperImpl implements ValuesMapper {

    @Override
    public Values mapToInner(DtoValues outer) {
        if ( outer == null ) {
            return null;
        }

        ValuesBuilder values = Values.builder();

        values.respuesta_1( outer.getRespuesta_1() );
        values.respuesta_2( outer.getRespuesta_2() );
        values.respuesta_3( outer.getRespuesta_3() );
        values.respuesta_4( outer.getRespuesta_4() );
        values.respuesta_5( outer.getRespuesta_5() );

        return values.build();
    }

    @Override
    public DtoValues mapToOuter(Values inner) {
        if ( inner == null ) {
            return null;
        }

        DtoValuesBuilder dtoValues = DtoValues.builder();

        dtoValues.respuesta_1( inner.getRespuesta_1() );
        dtoValues.respuesta_2( inner.getRespuesta_2() );
        dtoValues.respuesta_3( inner.getRespuesta_3() );
        dtoValues.respuesta_4( inner.getRespuesta_4() );
        dtoValues.respuesta_5( inner.getRespuesta_5() );

        return dtoValues.build();
    }
}
