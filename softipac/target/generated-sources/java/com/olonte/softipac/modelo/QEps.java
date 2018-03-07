package com.olonte.softipac.modelo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEps is a Querydsl query type for Eps
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEps extends EntityPathBase<Eps> {

    private static final long serialVersionUID = -2099452761L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEps eps = new QEps("eps");

    public final QDatos datos_iddatos;

    public final StringPath direccion = createString("direccion");

    public final StringPath email = createString("email");

    public final NumberPath<Integer> idEps = createNumber("idEps", Integer.class);

    public final StringPath nit = createString("nit");

    public final StringPath razonSocial = createString("razonSocial");

    public final StringPath telefono = createString("telefono");

    public QEps(String variable) {
        this(Eps.class, forVariable(variable), INITS);
    }

    public QEps(Path<? extends Eps> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QEps(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QEps(PathMetadata metadata, PathInits inits) {
        this(Eps.class, metadata, inits);
    }

    public QEps(Class<? extends Eps> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.datos_iddatos = inits.isInitialized("datos_iddatos") ? new QDatos(forProperty("datos_iddatos")) : null;
    }

}

