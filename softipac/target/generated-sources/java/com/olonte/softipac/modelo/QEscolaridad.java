package com.olonte.softipac.modelo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEscolaridad is a Querydsl query type for Escolaridad
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEscolaridad extends EntityPathBase<Escolaridad> {

    private static final long serialVersionUID = 850652992L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEscolaridad escolaridad1 = new QEscolaridad("escolaridad1");

    public final QDatos datos_iddatos;

    public final StringPath escolaridad = createString("escolaridad");

    public final NumberPath<Integer> idEscolaridad = createNumber("idEscolaridad", Integer.class);

    public QEscolaridad(String variable) {
        this(Escolaridad.class, forVariable(variable), INITS);
    }

    public QEscolaridad(Path<? extends Escolaridad> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QEscolaridad(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QEscolaridad(PathMetadata metadata, PathInits inits) {
        this(Escolaridad.class, metadata, inits);
    }

    public QEscolaridad(Class<? extends Escolaridad> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.datos_iddatos = inits.isInitialized("datos_iddatos") ? new QDatos(forProperty("datos_iddatos")) : null;
    }

}

