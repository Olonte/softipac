package com.olonte.softipac.modelo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAfinidadUsuarioId is a Querydsl query type for AfinidadUsuarioId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QAfinidadUsuarioId extends BeanPath<AfinidadUsuarioId> {

    private static final long serialVersionUID = 1032963456L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAfinidadUsuarioId afinidadUsuarioId = new QAfinidadUsuarioId("afinidadUsuarioId");

    public final QUsuario idfamiliar;

    public final QUsuario usuario_idusuario;

    public QAfinidadUsuarioId(String variable) {
        this(AfinidadUsuarioId.class, forVariable(variable), INITS);
    }

    public QAfinidadUsuarioId(Path<? extends AfinidadUsuarioId> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QAfinidadUsuarioId(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QAfinidadUsuarioId(PathMetadata metadata, PathInits inits) {
        this(AfinidadUsuarioId.class, metadata, inits);
    }

    public QAfinidadUsuarioId(Class<? extends AfinidadUsuarioId> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.idfamiliar = inits.isInitialized("idfamiliar") ? new QUsuario(forProperty("idfamiliar"), inits.get("idfamiliar")) : null;
        this.usuario_idusuario = inits.isInitialized("usuario_idusuario") ? new QUsuario(forProperty("usuario_idusuario"), inits.get("usuario_idusuario")) : null;
    }

}

