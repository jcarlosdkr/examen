package com.examen.mapper.impl;

import com.examen.dto.DtoOpcion;
import com.examen.dto.DtoOpcion.DtoOpcionBuilder;
import com.examen.entity.Opcion;
import com.examen.entity.Opcion.OpcionBuilder;
import com.examen.mapper.OpcionMapper;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-07-07T22:41:16-0500",
    comments = "version: 1.4.1.Final, compiler: javac, environment: Java 11.0.12 (Oracle Corporation)"
)
@Component
public class OpcionMapperImpl implements OpcionMapper {

    @Override
    public Opcion mapToInner(DtoOpcion outer) {
        if ( outer == null ) {
            return null;
        }

        OpcionBuilder opcion = Opcion.builder();

        opcion.id( outer.getId() );
        opcion.resp_A( outer.getResp_A() );
        opcion.resp_B( outer.getResp_B() );
        opcion.resp_C( outer.getResp_C() );
        opcion.resp_D( outer.getResp_D() );

        return opcion.build();
    }

    @Override
    public DtoOpcion mapToOuter(Opcion inner) {
        if ( inner == null ) {
            return null;
        }

        DtoOpcionBuilder dtoOpcion = DtoOpcion.builder();

        dtoOpcion.id( inner.getId() );
        dtoOpcion.resp_A( inner.getResp_A() );
        dtoOpcion.resp_B( inner.getResp_B() );
        dtoOpcion.resp_C( inner.getResp_C() );
        dtoOpcion.resp_D( inner.getResp_D() );

        return dtoOpcion.build();
    }
}
