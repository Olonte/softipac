package com.olonte.softipac.modelo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QHora is a Querydsl query type for Hora
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHora extends EntityPathBase<Hora> {

    private static final long serialVersionUID = -658437673L;

    public static final QHora hora1 = new QHora("hora1");

    public final SetPath<Cita, QCita> citas = this.<Cita, QCita>createSet("citas", Cita.class, QCita.class, PathInits.DIRECT2);

    public final StringPath hora = createString("hora");

    public final NumberPath<Integer> idHora = createNumber("idHora", Integer.class);

    public QHora(String variable) {
        super(Hora.class, forVariable(variable));
    }

    public QHora(Path<? extends Hora> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHora(PathMetadata metadata) {
        super(Hora.class, metadata);
    }

}

