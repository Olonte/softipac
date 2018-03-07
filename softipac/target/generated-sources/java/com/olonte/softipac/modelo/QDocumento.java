package com.olonte.softipac.modelo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDocumento is a Querydsl query type for Documento
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDocumento extends EntityPathBase<Documento> {

    private static final long serialVersionUID = 2085619L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDocumento documento1 = new QDocumento("documento1");

    public final StringPath documento = createString("documento");

    public final NumberPath<Integer> idDocumento = createNumber("idDocumento", Integer.class);

    public final QTipoDocumento tipoDocumento;

    public QDocumento(String variable) {
        this(Documento.class, forVariable(variable), INITS);
    }

    public QDocumento(Path<? extends Documento> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QDocumento(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QDocumento(PathMetadata metadata, PathInits inits) {
        this(Documento.class, metadata, inits);
    }

    public QDocumento(Class<? extends Documento> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.tipoDocumento = inits.isInitialized("tipoDocumento") ? new QTipoDocumento(forProperty("tipoDocumento"), inits.get("tipoDocumento")) : null;
    }

}

