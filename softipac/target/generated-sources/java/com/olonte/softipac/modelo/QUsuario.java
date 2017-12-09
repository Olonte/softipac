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

    public final QDocumento documento;

    public final NumberPath<Integer> edad = createNumber("edad", Integer.class);

    public final StringPath email = createString("email");

    public final QEps eps;

    public final QEscolaridad escolaridad;

    public final QEstado estado;

    public final DatePath<java.time.LocalDate> fechaNacimiento = createDate("fechaNacimiento", java.time.LocalDate.class);

    public final QGenero genero;

    public final NumberPath<Integer> idUsuario = createNumber("idUsuario", Integer.class);

    public final StringPath lugarNacimiento = createString("lugarNacimiento");

    public final StringPath meses = createString("meses");

    public final StringPath nombres = createString("nombres");

    public final StringPath nomnbreUsuario = createString("nomnbreUsuario");

    public final StringPath ocupacion = createString("ocupacion");

    public final QParentesco parentesco;

    public final StringPath password = createString("password");

    public final StringPath primerApellido = createString("primerApellido");

    public final SetPath<Rol, QRol> roles = this.<Rol, QRol>createSet("roles", Rol.class, QRol.class, PathInits.DIRECT2);

    public final StringPath segundoApellido = createString("segundoApellido");

    public final QServicioSalud servicioSalud;

    public final StringPath telefonoCelular = createString("telefonoCelular");

    public final StringPath telefonoFijo = createString("telefonoFijo");

    public final QTipoUsuario tipoUsuario;

    public final StringPath tutela = createString("tutela");

    public final SetPath<Cita, QCita> usuario_idusuapl = this.<Cita, QCita>createSet("usuario_idusuapl", Cita.class, QCita.class, PathInits.DIRECT2);

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
        this.documento = inits.isInitialized("documento") ? new QDocumento(forProperty("documento"), inits.get("documento")) : null;
        this.eps = inits.isInitialized("eps") ? new QEps(forProperty("eps")) : null;
        this.escolaridad = inits.isInitialized("escolaridad") ? new QEscolaridad(forProperty("escolaridad")) : null;
        this.estado = inits.isInitialized("estado") ? new QEstado(forProperty("estado")) : null;
        this.genero = inits.isInitialized("genero") ? new QGenero(forProperty("genero")) : null;
        this.parentesco = inits.isInitialized("parentesco") ? new QParentesco(forProperty("parentesco")) : null;
        this.servicioSalud = inits.isInitialized("servicioSalud") ? new QServicioSalud(forProperty("servicioSalud")) : null;
        this.tipoUsuario = inits.isInitialized("tipoUsuario") ? new QTipoUsuario(forProperty("tipoUsuario")) : null;
    }

}

