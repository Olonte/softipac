package com.olonte.softipac.modelo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCitaUsuarioId is a Querydsl query type for CitaUsuarioId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QCitaUsuarioId extends BeanPath<CitaUsuarioId> {

    private static final long serialVersionUID = 1076790677L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCitaUsuarioId citaUsuarioId = new QCitaUsuarioId("citaUsuarioId");

    public final QUsuario usuario_idusuapl;

    public final QUsuario usuario_idusuario;

    public QCitaUsuarioId(String variable) {
        this(CitaUsuarioId.class, forVariable(variable), INITS);
    }

    public QCitaUsuarioId(Path<? extends CitaUsuarioId> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QCitaUsuarioId(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QCitaUsuarioId(PathMetadata metadata, PathInits inits) {
        this(CitaUsuarioId.class, metadata, inits);
    }

    public QCitaUsuarioId(Class<? extends CitaUsuarioId> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.usuario_idusuapl = inits.isInitialized("usuario_idusuapl") ? new QUsuario(forProperty("usuario_idusuapl"), inits.get("usuario_idusuapl")) : null;
        this.usuario_idusuario = inits.isInitialized("usuario_idusuario") ? new QUsuario(forProperty("usuario_idusuario"), inits.get("usuario_idusuario")) : null;
    }

}

