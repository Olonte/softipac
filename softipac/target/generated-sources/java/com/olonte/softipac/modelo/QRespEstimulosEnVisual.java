package com.olonte.softipac.modelo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRespEstimulosEnVisual is a Querydsl query type for RespEstimulosEnVisual
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRespEstimulosEnVisual extends EntityPathBase<RespEstimulosEnVisual> {

    private static final long serialVersionUID = -959389923L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRespEstimulosEnVisual respEstimulosEnVisual = new QRespEstimulosEnVisual("respEstimulosEnVisual");

    public final StringPath acerca_aleja = createString("acerca_aleja");

    public final StringPath buscamirada = createString("buscamirada");

    public final StringPath entrecierra = createString("entrecierra");

    public final StringPath giraobjetos = createString("giraobjetos");

    public final QHistoriaClinica historiaclinica_idhistoriaclinica;

    public final NumberPath<Integer> idRespEstimulosEnVisual = createNumber("idRespEstimulosEnVisual", Integer.class);

    public final StringPath miradaperdida = createString("miradaperdida");

    public final StringPath orientamirada = createString("orientamirada");

    public final StringPath perspectiva = createString("perspectiva");

    public final StringPath reojo = createString("reojo");

    public QRespEstimulosEnVisual(String variable) {
        this(RespEstimulosEnVisual.class, forVariable(variable), INITS);
    }

    public QRespEstimulosEnVisual(Path<? extends RespEstimulosEnVisual> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QRespEstimulosEnVisual(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QRespEstimulosEnVisual(PathMetadata metadata, PathInits inits) {
        this(RespEstimulosEnVisual.class, metadata, inits);
    }

    public QRespEstimulosEnVisual(Class<? extends RespEstimulosEnVisual> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.historiaclinica_idhistoriaclinica = inits.isInitialized("historiaclinica_idhistoriaclinica") ? new QHistoriaClinica(forProperty("historiaclinica_idhistoriaclinica"), inits.get("historiaclinica_idhistoriaclinica")) : null;
    }

}

