package com.olonte.softipac.predicado;

import com.olonte.softipac.modelo.QDocumento;
import com.olonte.softipac.modelo.QUsuario;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.JPAExpressions;

public class UsuarioPredicado {
	
	private UsuarioPredicado() {
	}
	
	public static Predicate bucarPorNombreUsuario(String nombreUsuario) {
		return QUsuario.usuario.nomnbreUsuario.eq(nombreUsuario);
	}
	
	public static Predicate buscarPorDocumento(String documento) {
		return QUsuario.usuario.documento.idDocumento.eq(JPAExpressions.select(QDocumento.documento1.idDocumento)
				.from(QDocumento.documento1)
				.where(QDocumento.documento1.documento.eq(documento)));
	}

}
