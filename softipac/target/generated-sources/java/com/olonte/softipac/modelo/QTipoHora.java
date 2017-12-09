package com.olonte.softipac.modelo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTipoHora is a Querydsl query type for TipoHora
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTipoHora extends EntityPathBase<TipoHora> {

    private static final long serialVersionUID = -1181679957L;

    public static final QTipoHora tipoHora = new QTipoHora("tipoHora");

    public final SetPath<Hora, QHora> horas = this.<Hora, QHora>createSet("horas", Hora.class, QHora.class, PathInits.DIRECT2);

    public final NumberPath<Integer> idTipoHora = createNumber("idTipoHora", Integer.class);

    public final StringPath tipo = createString("tipo");

    public QTipoHora(String variable) {
        super(TipoHora.class, forVariable(variable));
    }

    public QTipoHora(Path<? extends TipoHora> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTipoHora(PathMetadata metadata) {
        super(TipoHora.class, metadata);
    }

}

