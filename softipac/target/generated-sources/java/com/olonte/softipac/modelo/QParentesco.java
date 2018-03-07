package com.olonte.softipac.modelo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QParentesco is a Querydsl query type for Parentesco
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QParentesco extends EntityPathBase<Parentesco> {

    private static final long serialVersionUID = 635424997L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QParentesco parentesco1 = new QParentesco("parentesco1");

    public final QDatos datos_iddatos;

    public final NumberPath<Integer> idParentesco = createNumber("idParentesco", Integer.class);

    public final StringPath parentesco = createString("parentesco");

    public QParentesco(String variable) {
        this(Parentesco.class, forVariable(variable), INITS);
    }

    public QParentesco(Path<? extends Parentesco> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QParentesco(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QParentesco(PathMetadata metadata, PathInits inits) {
        this(Parentesco.class, metadata, inits);
    }

    public QParentesco(Class<? extends Parentesco> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.datos_iddatos = inits.isInitialized("datos_iddatos") ? new QDatos(forProperty("datos_iddatos")) : null;
    }

}

