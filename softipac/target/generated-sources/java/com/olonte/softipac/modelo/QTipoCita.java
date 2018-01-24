package com.olonte.softipac.modelo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QTipoCita is a Querydsl query type for TipoCita
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTipoCita extends EntityPathBase<TipoCita> {

    private static final long serialVersionUID = -1181834616L;

    public static final QTipoCita tipoCita = new QTipoCita("tipoCita");

    public final NumberPath<Integer> idTipoCita = createNumber("idTipoCita", Integer.class);

    public final StringPath tipo = createString("tipo");

    public QTipoCita(String variable) {
        super(TipoCita.class, forVariable(variable));
    }

    public QTipoCita(Path<? extends TipoCita> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTipoCita(PathMetadata metadata) {
        super(TipoCita.class, metadata);
    }

}

