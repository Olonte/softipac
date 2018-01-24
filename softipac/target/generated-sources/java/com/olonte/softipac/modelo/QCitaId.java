package com.olonte.softipac.modelo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCitaId is a Querydsl query type for CitaId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QCitaId extends BeanPath<CitaId> {

    private static final long serialVersionUID = -1547036177L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCitaId citaId = new QCitaId("citaId");

    public final QEstado estado_idestado;

    public final NumberPath<Integer> idcita = createNumber("idcita", Integer.class);

    public final QTipoCita tipocita_idtipocita;

    public final QUsuario usuario_idusuapl;

    public final QUsuario usuario_idusuario;

    public QCitaId(String variable) {
        this(CitaId.class, forVariable(variable), INITS);
    }

    public QCitaId(Path<? extends CitaId> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QCitaId(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QCitaId(PathMetadata metadata, PathInits inits) {
        this(CitaId.class, metadata, inits);
    }

    public QCitaId(Class<? extends CitaId> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.estado_idestado = inits.isInitialized("estado_idestado") ? new QEstado(forProperty("estado_idestado")) : null;
        this.tipocita_idtipocita = inits.isInitialized("tipocita_idtipocita") ? new QTipoCita(forProperty("tipocita_idtipocita")) : null;
        this.usuario_idusuapl = inits.isInitialized("usuario_idusuapl") ? new QUsuario(forProperty("usuario_idusuapl"), inits.get("usuario_idusuapl")) : null;
        this.usuario_idusuario = inits.isInitialized("usuario_idusuario") ? new QUsuario(forProperty("usuario_idusuario"), inits.get("usuario_idusuario")) : null;
    }

}

