package com.olonte.softipac.modelo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCita is a Querydsl query type for Cita
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCita extends EntityPathBase<Cita> {

    private static final long serialVersionUID = -658592332L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCita cita = new QCita("cita");

    public final QCitaId citaId;

    public final StringPath expectativas = createString("expectativas");

    public final DatePath<java.time.LocalDate> fechaCitaIni = createDate("fechaCitaIni", java.time.LocalDate.class);

    public final QHora hora;

    public final StringPath inFoGral = createString("inFoGral");

    public final StringPath motivoConsulta = createString("motivoConsulta");

    public final StringPath observacion = createString("observacion");

    public final StringPath recomTenerCta = createString("recomTenerCta");

    public QCita(String variable) {
        this(Cita.class, forVariable(variable), INITS);
    }

    public QCita(Path<? extends Cita> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QCita(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QCita(PathMetadata metadata, PathInits inits) {
        this(Cita.class, metadata, inits);
    }

    public QCita(Class<? extends Cita> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.citaId = inits.isInitialized("citaId") ? new QCitaId(forProperty("citaId"), inits.get("citaId")) : null;
        this.hora = inits.isInitialized("hora") ? new QHora(forProperty("hora"), inits.get("hora")) : null;
    }

}

