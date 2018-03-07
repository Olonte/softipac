package com.olonte.softipac.modelo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDatos is a Querydsl query type for Datos
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDatos extends EntityPathBase<Datos> {

    private static final long serialVersionUID = 1059159930L;

    public static final QDatos datos = new QDatos("datos");

    public final StringPath datosCol = createString("datosCol");

    public final SetPath<Diagnostico, QDiagnostico> diagnosticos = this.<Diagnostico, QDiagnostico>createSet("diagnosticos", Diagnostico.class, QDiagnostico.class, PathInits.DIRECT2);

    public final SetPath<Eps, QEps> eps = this.<Eps, QEps>createSet("eps", Eps.class, QEps.class, PathInits.DIRECT2);

    public final SetPath<Escolaridad, QEscolaridad> escolaridades = this.<Escolaridad, QEscolaridad>createSet("escolaridades", Escolaridad.class, QEscolaridad.class, PathInits.DIRECT2);

    public final SetPath<Genero, QGenero> generos = this.<Genero, QGenero>createSet("generos", Genero.class, QGenero.class, PathInits.DIRECT2);

    public final NumberPath<Integer> idDatos = createNumber("idDatos", Integer.class);

    public final SetPath<Parentesco, QParentesco> parentescos = this.<Parentesco, QParentesco>createSet("parentescos", Parentesco.class, QParentesco.class, PathInits.DIRECT2);

    public final SetPath<TipoDocumento, QTipoDocumento> tipoDocumentos = this.<TipoDocumento, QTipoDocumento>createSet("tipoDocumentos", TipoDocumento.class, QTipoDocumento.class, PathInits.DIRECT2);

    public QDatos(String variable) {
        super(Datos.class, forVariable(variable));
    }

    public QDatos(Path<? extends Datos> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDatos(PathMetadata metadata) {
        super(Datos.class, metadata);
    }

}

