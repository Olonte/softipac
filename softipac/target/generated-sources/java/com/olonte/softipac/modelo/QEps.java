package com.olonte.softipac.modelo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEps is a Querydsl query type for Eps
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QEps extends EntityPathBase<Eps> {

    private static final long serialVersionUID = -2099452761L;

    public static final QEps eps = new QEps("eps");

    public final StringPath direccion = createString("direccion");

    public final StringPath email = createString("email");

    public final NumberPath<Integer> idEps = createNumber("idEps", Integer.class);

    public final StringPath nit = createString("nit");

    public final StringPath razonSocial = createString("razonSocial");

    public final StringPath telefono = createString("telefono");

    public final SetPath<Usuario, QUsuario> usuarios = this.<Usuario, QUsuario>createSet("usuarios", Usuario.class, QUsuario.class, PathInits.DIRECT2);

    public QEps(String variable) {
        super(Eps.class, forVariable(variable));
    }

    public QEps(Path<? extends Eps> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEps(PathMetadata metadata) {
        super(Eps.class, metadata);
    }

}

