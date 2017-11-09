package com.olonte.softipac.modelo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEscolaridad is a Querydsl query type for Escolaridad
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEscolaridad extends EntityPathBase<Escolaridad> {

    private static final long serialVersionUID = 850652992L;

    public static final QEscolaridad escolaridad1 = new QEscolaridad("escolaridad1");

    public final StringPath escolaridad = createString("escolaridad");

    public final NumberPath<Integer> idEscolaridad = createNumber("idEscolaridad", Integer.class);

    public final SetPath<Usuario, QUsuario> usuarios = this.<Usuario, QUsuario>createSet("usuarios", Usuario.class, QUsuario.class, PathInits.DIRECT2);

    public QEscolaridad(String variable) {
        super(Escolaridad.class, forVariable(variable));
    }

    public QEscolaridad(Path<? extends Escolaridad> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEscolaridad(PathMetadata metadata) {
        super(Escolaridad.class, metadata);
    }

}

