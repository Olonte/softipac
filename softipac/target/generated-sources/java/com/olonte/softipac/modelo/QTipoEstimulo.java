package com.olonte.softipac.modelo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTipoEstimulo is a Querydsl query type for TipoEstimulo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTipoEstimulo extends EntityPathBase<TipoEstimulo> {

    private static final long serialVersionUID = 374265347L;

    public static final QTipoEstimulo tipoEstimulo = new QTipoEstimulo("tipoEstimulo");

    public final SetPath<Estimulo, QEstimulo> estimulos = this.<Estimulo, QEstimulo>createSet("estimulos", Estimulo.class, QEstimulo.class, PathInits.DIRECT2);

    public final NumberPath<Integer> idTipoEstimulo = createNumber("idTipoEstimulo", Integer.class);

    public final StringPath tipo = createString("tipo");

    public QTipoEstimulo(String variable) {
        super(TipoEstimulo.class, forVariable(variable));
    }

    public QTipoEstimulo(Path<? extends TipoEstimulo> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTipoEstimulo(PathMetadata metadata) {
        super(TipoEstimulo.class, metadata);
    }

}

