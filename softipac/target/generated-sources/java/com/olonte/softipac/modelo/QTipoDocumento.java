package com.olonte.softipac.modelo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTipoDocumento is a Querydsl query type for TipoDocumento
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTipoDocumento extends EntityPathBase<TipoDocumento> {

    private static final long serialVersionUID = 283886239L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTipoDocumento tipoDocumento = new QTipoDocumento("tipoDocumento");

    public final QDatos datos_iddatos;

    public final NumberPath<Integer> idTipoDocumento = createNumber("idTipoDocumento", Integer.class);

    public final StringPath tipo = createString("tipo");

    public QTipoDocumento(String variable) {
        this(TipoDocumento.class, forVariable(variable), INITS);
    }

    public QTipoDocumento(Path<? extends TipoDocumento> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QTipoDocumento(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QTipoDocumento(PathMetadata metadata, PathInits inits) {
        this(TipoDocumento.class, metadata, inits);
    }

    public QTipoDocumento(Class<? extends TipoDocumento> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.datos_iddatos = inits.isInitialized("datos_iddatos") ? new QDatos(forProperty("datos_iddatos")) : null;
    }

}

