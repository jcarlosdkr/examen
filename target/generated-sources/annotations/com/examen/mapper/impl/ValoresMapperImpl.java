package com.examen.mapper.impl;

import com.examen.dto.DtoValores;
import com.examen.dto.DtoValores.DtoValoresBuilder;
import com.examen.entity.Valores;
import com.examen.entity.Valores.ValoresBuilder;
import com.examen.mapper.ValoresMapper;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-07T22:41:16-0500",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
public class ValoresMapperImpl implements ValoresMapper {

    @Override
    public Valores mapToInner(DtoValores outer) {
        if ( outer == null ) {
            return null;
        }

        ValoresBuilder valores = Valores.builder();

        valores.id( outer.getId() );
        valores.valor( outer.getValor() );

        return valores.build();
    }

    @Override
    public DtoValores mapToOuter(Valores inner) {
        if ( inner == null ) {
            return null;
        }

        DtoValoresBuilder dtoValores = DtoValores.builder();

        dtoValores.id( inner.getId() );
        dtoValores.valor( inner.getValor() );

        return dtoValores.build();
    }
}
