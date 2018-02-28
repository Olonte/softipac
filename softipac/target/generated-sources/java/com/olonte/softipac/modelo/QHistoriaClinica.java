package com.olonte.softipac.modelo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QHistoriaClinica is a Querydsl query type for HistoriaClinica
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHistoriaClinica extends EntityPathBase<HistoriaClinica> {

    private static final long serialVersionUID = -638953893L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QHistoriaClinica historiaClinica = new QHistoriaClinica("historiaClinica");

    public final StringPath caractambiente = createString("caractambiente");

    public final SetPath<Estimulo, QEstimulo> estimulos = this.<Estimulo, QEstimulo>createSet("estimulos", Estimulo.class, QEstimulo.class, PathInits.DIRECT2);

    public final StringPath habilespeciales = createString("habilespeciales");

    public final NumberPath<Integer> idHistoriaClinica = createNumber("idHistoriaClinica", Integer.class);

    public final StringPath motivoconsulta = createString("motivoconsulta");

    public final StringPath problemascond = createString("problemascond");

    public final QRemision remision;

    public final QRepertorioBasico repertorioBasico;

    public final QResistenciaCambio resistenciaCambio;

    public final QRespEstimulosEnVisual respEstimulosEnVisual;

    public QHistoriaClinica(String variable) {
        this(HistoriaClinica.class, forVariable(variable), INITS);
    }

    public QHistoriaClinica(Path<? extends HistoriaClinica> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QHistoriaClinica(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QHistoriaClinica(PathMetadata metadata, PathInits inits) {
        this(HistoriaClinica.class, metadata, inits);
    }

    public QHistoriaClinica(Class<? extends HistoriaClinica> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.remision = inits.isInitialized("remision") ? new QRemision(forProperty("remision"), inits.get("remision")) : null;
        this.repertorioBasico = inits.isInitialized("repertorioBasico") ? new QRepertorioBasico(forProperty("repertorioBasico"), inits.get("repertorioBasico")) : null;
        this.resistenciaCambio = inits.isInitialized("resistenciaCambio") ? new QResistenciaCambio(forProperty("resistenciaCambio"), inits.get("resistenciaCambio")) : null;
        this.respEstimulosEnVisual = inits.isInitialized("respEstimulosEnVisual") ? new QRespEstimulosEnVisual(forProperty("respEstimulosEnVisual"), inits.get("respEstimulosEnVisual")) : null;
    }

}

