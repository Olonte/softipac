package com.olonte.softipac.predicado;

import com.olonte.softipac.modelo.QAfinidad;
import com.olonte.softipac.modelo.QDocumento;
import com.olonte.softipac.modelo.QUsuario;
import com.olonte.softipac.utilidad.Utilidad;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.JPAExpressions;

public class UsuarioPredicado {
	
	private UsuarioPredicado() {
	}
	
	public static Predicate bucarPorNombreUsuario(String nombreUsuario) {
		return QUsuario.usuario.nomnbreUsuario.eq(nombreUsuario);
	}
	
	public static Predicate buscarPorDocumento(String documento) {
		return QUsuario.usuario.documento.idDocumento.eq(JPAExpressions
				.select(QDocumento.documento1.idDocumento)
				.from(QDocumento.documento1)
				.where(QDocumento.documento1.documento.eq(documento)));
	}
	
	public static Predicate buscarPorIdUsuario(Integer idUsuario) {
		return QUsuario.usuario.idUsuario.eq(JPAExpressions
				.select(QAfinidad.afinidad.afinidadUsuarioId.idfamiliar.idUsuario)
				.from(QAfinidad.afinidad)
				.where(QAfinidad.afinidad.afinidadUsuarioId.usuario_idusuario.idUsuario.eq(idUsuario)
						.and(QUsuario.usuario.tipoUsuario.idTipoUsuario.eq(Utilidad.USUARIO_ACUDIENTE))));
	}

}
