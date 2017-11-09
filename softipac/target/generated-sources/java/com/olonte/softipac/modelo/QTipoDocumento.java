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

    public static final QTipoDocumento tipoDocumento = new QTipoDocumento("tipoDocumento");

    public final SetPath<Documento, QDocumento> documentos = this.<Documento, QDocumento>createSet("documentos", Documento.class, QDocumento.class, PathInits.DIRECT2);

    public final NumberPath<Integer> idTipoDocumento = createNumber("idTipoDocumento", Integer.class);

    public final StringPath tipo = createString("tipo");

    public QTipoDocumento(String variable) {
        super(TipoDocumento.class, forVariable(variable));
    }

    public QTipoDocumento(Path<? extends TipoDocumento> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTipoDocumento(PathMetadata metadata) {
        super(TipoDocumento.class, metadata);
    }

}

