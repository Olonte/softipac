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

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QHora hora1 = new QHora("hora1");

    public final SetPath<Cita, QCita> citas = this.<Cita, QCita>createSet("citas", Cita.class, QCita.class, PathInits.DIRECT2);

    public final StringPath hora = createString("hora");

    public final NumberPath<Integer> idHora = createNumber("idHora", Integer.class);

    public final QTipoHora tipoHora;

    public QHora(String variable) {
        this(Hora.class, forVariable(variable), INITS);
    }

    public QHora(Path<? extends Hora> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QHora(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QHora(PathMetadata metadata, PathInits inits) {
        this(Hora.class, metadata, inits);
    }

    public QHora(Class<? extends Hora> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.tipoHora = inits.isInitialized("tipoHora") ? new QTipoHora(forProperty("tipoHora")) : null;
    }

}

