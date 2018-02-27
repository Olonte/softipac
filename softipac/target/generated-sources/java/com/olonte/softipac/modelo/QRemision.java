package com.olonte.softipac.modelo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRemision is a Querydsl query type for Remision
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRemision extends EntityPathBase<Remision> {

    private static final long serialVersionUID = 282465829L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRemision remision = new QRemision("remision");

    public final QHistoriaClinica historiaclinica_idhistoriaclinica;

    public final NumberPath<Integer> idRemision = createNumber("idRemision", Integer.class);

    public final StringPath motivo = createString("motivo");

    public final StringPath remitidoPor = createString("remitidoPor");

    public QRemision(String variable) {
        this(Remision.class, forVariable(variable), INITS);
    }

    public QRemision(Path<? extends Remision> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QRemision(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QRemision(PathMetadata metadata, PathInits inits) {
        this(Remision.class, metadata, inits);
    }

    public QRemision(Class<? extends Remision> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.historiaclinica_idhistoriaclinica = inits.isInitialized("historiaclinica_idhistoriaclinica") ? new QHistoriaClinica(forProperty("historiaclinica_idhistoriaclinica"), inits.get("historiaclinica_idhistoriaclinica")) : null;
    }

}

