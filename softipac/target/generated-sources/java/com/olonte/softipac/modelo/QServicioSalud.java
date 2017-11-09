package com.olonte.softipac.modelo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QServicioSalud is a Querydsl query type for ServicioSalud
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QServicioSalud extends EntityPathBase<ServicioSalud> {

    private static final long serialVersionUID = -1669617546L;

    public static final QServicioSalud servicioSalud = new QServicioSalud("servicioSalud");

    public final NumberPath<Integer> idServicioSalud = createNumber("idServicioSalud", Integer.class);

    public final StringPath nit = createString("nit");

    public final StringPath rips = createString("rips");

    public final StringPath servicio = createString("servicio");

    public final SetPath<Usuario, QUsuario> usuarios = this.<Usuario, QUsuario>createSet("usuarios", Usuario.class, QUsuario.class, PathInits.DIRECT2);

    public QServicioSalud(String variable) {
        super(ServicioSalud.class, forVariable(variable));
    }

    public QServicioSalud(Path<? extends ServicioSalud> path) {
        super(path.getType(), path.getMetadata());
    }

    public QServicioSalud(PathMetadata metadata) {
        super(ServicioSalud.class, metadata);
    }

}

