package com.olonte.softipac.modelo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGenero is a Querydsl query type for Genero
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGenero extends EntityPathBase<Genero> {

    private static final long serialVersionUID = -1436387277L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QGenero genero1 = new QGenero("genero1");

    public final QDatos datos_iddatos;

    public final StringPath genero = createString("genero");

    public final NumberPath<Integer> idGenero = createNumber("idGenero", Integer.class);

    public QGenero(String variable) {
        this(Genero.class, forVariable(variable), INITS);
    }

    public QGenero(Path<? extends Genero> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QGenero(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QGenero(PathMetadata metadata, PathInits inits) {
        this(Genero.class, metadata, inits);
    }

    public QGenero(Class<? extends Genero> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.datos_iddatos = inits.isInitialized("datos_iddatos") ? new QDatos(forProperty("datos_iddatos")) : null;
    }

}

