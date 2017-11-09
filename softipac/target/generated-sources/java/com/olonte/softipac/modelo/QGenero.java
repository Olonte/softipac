package com.olonte.softipac.modelo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QGenero is a Querydsl query type for Genero
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QGenero extends EntityPathBase<Genero> {

    private static final long serialVersionUID = -1436387277L;

    public static final QGenero genero1 = new QGenero("genero1");

    public final StringPath genero = createString("genero");

    public final NumberPath<Integer> idGenero = createNumber("idGenero", Integer.class);

    public final SetPath<Usuario, QUsuario> usuarios = this.<Usuario, QUsuario>createSet("usuarios", Usuario.class, QUsuario.class, PathInits.DIRECT2);

    public QGenero(String variable) {
        super(Genero.class, forVariable(variable));
    }

    public QGenero(Path<? extends Genero> path) {
        super(path.getType(), path.getMetadata());
    }

    public QGenero(PathMetadata metadata) {
        super(Genero.class, metadata);
    }

}

