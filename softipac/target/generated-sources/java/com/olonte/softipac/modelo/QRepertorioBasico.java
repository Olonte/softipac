package com.olonte.softipac.modelo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRepertorioBasico is a Querydsl query type for RepertorioBasico
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRepertorioBasico extends EntityPathBase<RepertorioBasico> {

    private static final long serialVersionUID = -966729803L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRepertorioBasico repertorioBasico = new QRepertorioBasico("repertorioBasico");

    public final StringPath atencion = createString("atencion");

    public final StringPath contactovisual = createString("contactovisual");

    public final StringPath esqcorporal = createString("esqcorporal");

    public final QHistoriaClinica historiaclinica_idhistoriaclinica;

    public final NumberPath<Integer> idRepertorioBasico = createNumber("idRepertorioBasico", Integer.class);

    public final StringPath imitacionmotora = createString("imitacionmotora");

    public final StringPath imitacionobjetos = createString("imitacionobjetos");

    public final StringPath seguinstrucciones = createString("seguinstrucciones");

    public QRepertorioBasico(String variable) {
        this(RepertorioBasico.class, forVariable(variable), INITS);
    }

    public QRepertorioBasico(Path<? extends RepertorioBasico> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QRepertorioBasico(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QRepertorioBasico(PathMetadata metadata, PathInits inits) {
        this(RepertorioBasico.class, metadata, inits);
    }

    public QRepertorioBasico(Class<? extends RepertorioBasico> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.historiaclinica_idhistoriaclinica = inits.isInitialized("historiaclinica_idhistoriaclinica") ? new QHistoriaClinica(forProperty("historiaclinica_idhistoriaclinica"), inits.get("historiaclinica_idhistoriaclinica")) : null;
    }

}

