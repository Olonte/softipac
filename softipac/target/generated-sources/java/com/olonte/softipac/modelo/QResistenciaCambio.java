package com.olonte.softipac.modelo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QResistenciaCambio is a Querydsl query type for ResistenciaCambio
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QResistenciaCambio extends EntityPathBase<ResistenciaCambio> {

    private static final long serialVersionUID = 839191552L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QResistenciaCambio resistenciaCambio = new QResistenciaCambio("resistenciaCambio");

    public final StringPath actvrepetiivas = createString("actvrepetiivas");

    public final StringPath apegoobjetos = createString("apegoobjetos");

    public final StringPath cambioshorarios = createString("cambioshorarios");

    public final QHistoriaClinica historiaclinica_idhistoriaclinica;

    public final NumberPath<Integer> idResistenciaCambio = createNumber("idResistenciaCambio", Integer.class);

    public final StringPath rutas = createString("rutas");

    public final StringPath ubicacionesp = createString("ubicacionesp");

    public QResistenciaCambio(String variable) {
        this(ResistenciaCambio.class, forVariable(variable), INITS);
    }

    public QResistenciaCambio(Path<? extends ResistenciaCambio> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QResistenciaCambio(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QResistenciaCambio(PathMetadata metadata, PathInits inits) {
        this(ResistenciaCambio.class, metadata, inits);
    }

    public QResistenciaCambio(Class<? extends ResistenciaCambio> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.historiaclinica_idhistoriaclinica = inits.isInitialized("historiaclinica_idhistoriaclinica") ? new QHistoriaClinica(forProperty("historiaclinica_idhistoriaclinica"), inits.get("historiaclinica_idhistoriaclinica")) : null;
    }

}

