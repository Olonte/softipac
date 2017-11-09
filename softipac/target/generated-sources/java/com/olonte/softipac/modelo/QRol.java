package com.olonte.softipac.modelo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRol is a Querydsl query type for Rol
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRol extends EntityPathBase<Rol> {

    private static final long serialVersionUID = -2099440306L;

    public static final QRol rol1 = new QRol("rol1");

    public final NumberPath<Integer> idRol = createNumber("idRol", Integer.class);

    public final StringPath rol = createString("rol");

    public final SetPath<Usuario, QUsuario> usuarios = this.<Usuario, QUsuario>createSet("usuarios", Usuario.class, QUsuario.class, PathInits.DIRECT2);

    public QRol(String variable) {
        super(Rol.class, forVariable(variable));
    }

    public QRol(Path<? extends Rol> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRol(PathMetadata metadata) {
        super(Rol.class, metadata);
    }

}

