package com.olonte.softipac.predicado;

import com.olonte.softipac.modelo.QCita;
import com.olonte.softipac.modelo.QDocumento;
import com.olonte.softipac.modelo.QUsuario;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.JPAExpressions;

public class CitaPredicado {
	
	private CitaPredicado(){
	}
	
	public static Predicate buscarPorDocumento(String documento) {
		
		return QCita.cita.citaUsuarioId.usuario_idusuario.idUsuario.eq(JPAExpressions
				.select(QUsuario.usuario.idUsuario)
				.from(QUsuario.usuario)
				.where(QUsuario.usuario.documento.idDocumento.eq(JPAExpressions
						.select(QDocumento.documento1.idDocumento)
						.from(QDocumento.documento1)
						.where(QDocumento.documento1.documento.eq(documento) ) ) ) );
	}
}
