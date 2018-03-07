package com.olonte.softipac.modelo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDiagnostico is a Querydsl query type for Diagnostico
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDiagnostico extends EntityPathBase<Diagnostico> {

    private static final long serialVersionUID = 757204519L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDiagnostico diagnostico1 = new QDiagnostico("diagnostico1");

    public final QDatos datos_iddatos;

    public final StringPath diagnostico = createString("diagnostico");

    public final NumberPath<Integer> idDiagnostico = createNumber("idDiagnostico", Integer.class);

    public final QTipoDiagnostico tipoDiagnostico;

    public final SetPath<Usuario, QUsuario> usuarios = this.<Usuario, QUsuario>createSet("usuarios", Usuario.class, QUsuario.class, PathInits.DIRECT2);

    public QDiagnostico(String variable) {
        this(Diagnostico.class, forVariable(variable), INITS);
    }

    public QDiagnostico(Path<? extends Diagnostico> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QDiagnostico(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QDiagnostico(PathMetadata metadata, PathInits inits) {
        this(Diagnostico.class, metadata, inits);
    }

    public QDiagnostico(Class<? extends Diagnostico> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.datos_iddatos = inits.isInitialized("datos_iddatos") ? new QDatos(forProperty("datos_iddatos")) : null;
        this.tipoDiagnostico = inits.isInitialized("tipoDiagnostico") ? new QTipoDiagnostico(forProperty("tipoDiagnostico")) : null;
    }

}

