package com.olonte.softipac.modelo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAfinidad is a Querydsl query type for Afinidad
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QAfinidad extends EntityPathBase<Afinidad> {

    private static final long serialVersionUID = 1496762729L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAfinidad afinidad = new QAfinidad("afinidad");

    public final QAfinidadUsuarioId afinidadUsuarioId;

    public final SetPath<HistoriaClinica, QHistoriaClinica> historiaClinicas = this.<HistoriaClinica, QHistoriaClinica>createSet("historiaClinicas", HistoriaClinica.class, QHistoriaClinica.class, PathInits.DIRECT2);

    public final NumberPath<Integer> idAfinidad = createNumber("idAfinidad", Integer.class);

    public QAfinidad(String variable) {
        this(Afinidad.class, forVariable(variable), INITS);
    }

    public QAfinidad(Path<? extends Afinidad> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QAfinidad(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QAfinidad(PathMetadata metadata, PathInits inits) {
        this(Afinidad.class, metadata, inits);
    }

    public QAfinidad(Class<? extends Afinidad> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.afinidadUsuarioId = inits.isInitialized("afinidadUsuarioId") ? new QAfinidadUsuarioId(forProperty("afinidadUsuarioId"), inits.get("afinidadUsuarioId")) : null;
    }

}

