package com.olonte.softipac.modelo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QTipoUsuario is a Querydsl query type for TipoUsuario
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTipoUsuario extends EntityPathBase<TipoUsuario> {

    private static final long serialVersionUID = 1189372377L;

    public static final QTipoUsuario tipoUsuario = new QTipoUsuario("tipoUsuario");

    public final NumberPath<Integer> idTipoUsuario = createNumber("idTipoUsuario", Integer.class);

    public final StringPath tipo = createString("tipo");

    public QTipoUsuario(String variable) {
        super(TipoUsuario.class, forVariable(variable));
    }

    public QTipoUsuario(Path<? extends TipoUsuario> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTipoUsuario(PathMetadata metadata) {
        super(TipoUsuario.class, metadata);
    }

}

