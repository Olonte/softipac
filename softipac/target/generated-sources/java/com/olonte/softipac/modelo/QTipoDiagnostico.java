package com.olonte.softipac.modelo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTipoDiagnostico is a Querydsl query type for TipoDiagnostico
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTipoDiagnostico extends EntityPathBase<TipoDiagnostico> {

    private static final long serialVersionUID = 984660691L;

    public static final QTipoDiagnostico tipoDiagnostico = new QTipoDiagnostico("tipoDiagnostico");

    public final SetPath<Diagnostico, QDiagnostico> diagnosticos = this.<Diagnostico, QDiagnostico>createSet("diagnosticos", Diagnostico.class, QDiagnostico.class, PathInits.DIRECT2);

    public final NumberPath<Integer> idTipoDiagnostico = createNumber("idTipoDiagnostico", Integer.class);

    public final StringPath tipo = createString("tipo");

    public QTipoDiagnostico(String variable) {
        super(TipoDiagnostico.class, forVariable(variable));
    }

    public QTipoDiagnostico(Path<? extends TipoDiagnostico> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTipoDiagnostico(PathMetadata metadata) {
        super(TipoDiagnostico.class, metadata);
    }

}

