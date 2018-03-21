package com.olonte.softipac.modelo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QEstado is a Querydsl query type for Estado
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEstado extends EntityPathBase<Estado> {

    private static final long serialVersionUID = -1480541817L;

    public static final QEstado estado1 = new QEstado("estado1");

    public final StringPath estado = createString("estado");

    public final NumberPath<Integer> idEstado = createNumber("idEstado", Integer.class);

    public QEstado(String variable) {
        super(Estado.class, forVariable(variable));
    }

    public QEstado(Path<? extends Estado> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEstado(PathMetadata metadata) {
        super(Estado.class, metadata);
    }

}

