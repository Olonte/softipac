package com.olonte.softipac.modelo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QParentesco is a Querydsl query type for Parentesco
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QParentesco extends EntityPathBase<Parentesco> {

    private static final long serialVersionUID = 635424997L;

    public static final QParentesco parentesco1 = new QParentesco("parentesco1");

    public final NumberPath<Integer> idParentesco = createNumber("idParentesco", Integer.class);

    public final StringPath parentesco = createString("parentesco");

    public final SetPath<Usuario, QUsuario> usuarios = this.<Usuario, QUsuario>createSet("usuarios", Usuario.class, QUsuario.class, PathInits.DIRECT2);

    public QParentesco(String variable) {
        super(Parentesco.class, forVariable(variable));
    }

    public QParentesco(Path<? extends Parentesco> path) {
        super(path.getType(), path.getMetadata());
    }

    public QParentesco(PathMetadata metadata) {
        super(Parentesco.class, metadata);
    }

}

