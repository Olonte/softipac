package com.olonte.softipac.modelo;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUsuario is a Querydsl query type for Usuario
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUsuario extends EntityPathBase<Usuario> {

    private static final long serialVersionUID = -1631029459L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUsuario usuario = new QUsuario("usuario");

    public final SetPath<Diagnostico, QDiagnostico> diagnosticos = this.<Diagnostico, QDiagnostico>createSet("diagnosticos", Diagnostico.class, QDiagnostico.class, PathInits.DIRECT2);

    public final StringPath direccion = createString("direccion");

    public final QDocumento documento_iddocumento;

    public final NumberPath<Integer> edad = createNumber("edad", Integer.class);

    public final StringPath email = createString("email");

    public final QEps eps_ideps;

    public final QEscolaridad escolaridad_idescolaridad;

    public final QEstado estado_idestado;

    public final DatePath<java.time.LocalDate> fechaNacimiento = createDate("fechaNacimiento", java.time.LocalDate.class);

    public final QGenero genero_idgenero;

    public final NumberPath<Integer> idUsuario = createNumber("idUsuario", Integer.class);

    public final StringPath lugarNacimiento = createString("lugarNacimiento");

    public final NumberPath<Integer> meses = createNumber("meses", Integer.class);

    public final StringPath nombres = createString("nombres");

    public final StringPath nombreUsuario = createString("nombreUsuario");

    public final StringPath ocupacion = createString("ocupacion");

    public final QParentesco parentesco_idparentesco;

    public final StringPath password = createString("password");

    public final StringPath primerApellido = createString("primerApellido");

    public final SetPath<Rol, QRol> roles = this.<Rol, QRol>createSet("roles", Rol.class, QRol.class, PathInits.DIRECT2);

    public final StringPath segundoApellido = createString("segundoApellido");

    public final QServicioSalud serviciosalud_idserviciosalud;

    public final StringPath telefonoCelular = createString("telefonoCelular");

    public final StringPath telefonoFijo = createString("telefonoFijo");

    public final QTipoUsuario tipousuario_idtipousuario;

    public final StringPath tutela = createString("tutela");

    public final SetPath<Afinidad, QAfinidad> usuario_idusuario = this.<Afinidad, QAfinidad>createSet("usuario_idusuario", Afinidad.class, QAfinidad.class, PathInits.DIRECT2);

    public QUsuario(String variable) {
        this(Usuario.class, forVariable(variable), INITS);
    }

    public QUsuario(Path<? extends Usuario> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QUsuario(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QUsuario(PathMetadata metadata, PathInits inits) {
        this(Usuario.class, metadata, inits);
    }

    public QUsuario(Class<? extends Usuario> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.documento_iddocumento = inits.isInitialized("documento_iddocumento") ? new QDocumento(forProperty("documento_iddocumento"), inits.get("documento_iddocumento")) : null;
        this.eps_ideps = inits.isInitialized("eps_ideps") ? new QEps(forProperty("eps_ideps"), inits.get("eps_ideps")) : null;
        this.escolaridad_idescolaridad = inits.isInitialized("escolaridad_idescolaridad") ? new QEscolaridad(forProperty("escolaridad_idescolaridad"), inits.get("escolaridad_idescolaridad")) : null;
        this.estado_idestado = inits.isInitialized("estado_idestado") ? new QEstado(forProperty("estado_idestado")) : null;
        this.genero_idgenero = inits.isInitialized("genero_idgenero") ? new QGenero(forProperty("genero_idgenero"), inits.get("genero_idgenero")) : null;
        this.parentesco_idparentesco = inits.isInitialized("parentesco_idparentesco") ? new QParentesco(forProperty("parentesco_idparentesco"), inits.get("parentesco_idparentesco")) : null;
        this.serviciosalud_idserviciosalud = inits.isInitialized("serviciosalud_idserviciosalud") ? new QServicioSalud(forProperty("serviciosalud_idserviciosalud")) : null;
        this.tipousuario_idtipousuario = inits.isInitialized("tipousuario_idtipousuario") ? new QTipoUsuario(forProperty("tipousuario_idtipousuario")) : null;
    }

}

