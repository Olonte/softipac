package com.olonte.softipac.modelo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEstimulo is a Querydsl query type for Estimulo
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEstimulo extends EntityPathBase<Estimulo> {

    private static final long serialVersionUID = -1158845649L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEstimulo estimulo1 = new QEstimulo("estimulo1");

    public final StringPath estimulo = createString("estimulo");

    public final NumberPath<Integer> idEstimulo = createNumber("idEstimulo", Integer.class);

    public final QTipoEstimulo tipoEstimulo;

    public QEstimulo(String variable) {
        this(Estimulo.class, forVariable(variable), INITS);
    }

    public QEstimulo(Path<? extends Estimulo> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QEstimulo(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QEstimulo(PathMetadata metadata, PathInits inits) {
        this(Estimulo.class, metadata, inits);
    }

    public QEstimulo(Class<? extends Estimulo> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.tipoEstimulo = inits.isInitialized("tipoEstimulo") ? new QTipoEstimulo(forProperty("tipoEstimulo")) : null;
    }

}

