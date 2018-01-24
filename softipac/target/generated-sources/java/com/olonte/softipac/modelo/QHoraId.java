package com.olonte.softipac.modelo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QHoraId is a Querydsl query type for HoraId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QHoraId extends BeanPath<HoraId> {

    private static final long serialVersionUID = -1398408878L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QHoraId horaId = new QHoraId("horaId");

    public final NumberPath<Integer> idhora = createNumber("idhora", Integer.class);

    public final QTipoHora tipohora_idtipohora;

    public QHoraId(String variable) {
        this(HoraId.class, forVariable(variable), INITS);
    }

    public QHoraId(Path<? extends HoraId> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QHoraId(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QHoraId(PathMetadata metadata, PathInits inits) {
        this(HoraId.class, metadata, inits);
    }

    public QHoraId(Class<? extends HoraId> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.tipohora_idtipohora = inits.isInitialized("tipohora_idtipohora") ? new QTipoHora(forProperty("tipohora_idtipohora")) : null;
    }

}

