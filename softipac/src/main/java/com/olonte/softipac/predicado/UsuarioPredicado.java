package com.olonte.softipac.predicado;

import javax.persistence.EntityManager;

import com.olonte.softipac.modelo.QAfinidad;
import com.olonte.softipac.modelo.QDocumento;
import com.olonte.softipac.modelo.QUsuario;
import com.olonte.softipac.utilidad.Parametro;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.JPQLQueryFactory;
import com.querydsl.jpa.impl.JPAQueryFactory;

public class UsuarioPredicado {
	
	private UsuarioPredicado() {
	}
	
	public static Predicate bucarPorNombreUsuario(String nombreUsuario) {
		return QUsuario.usuario.nombreUsuario.eq(nombreUsuario);
	}
	
	public static Predicate buscarPorDocumento(String parametros) {
		
		Parametro parametro = new Parametro(parametros);
		
		return QUsuario.usuario.documento_iddocumento.idDocumento.in(
				JPAExpressions
				.select(QDocumento.documento1.idDocumento)
				.from(QDocumento.documento1)
				.where(QDocumento.documento1.documento.eq(parametro.getDocumento()))
			).and(QUsuario.usuario.tipousuario_idtipousuario.idTipoUsuario.in(parametro.getIds()));
	}
	
	public static Predicate buscarAcudientePorId(Integer idUsuario, Integer idTipoUsuario) {
		return QUsuario.usuario.idUsuario.in(
				JPAExpressions
				.select(QAfinidad.afinidad.afinidadUsuarioId.idfamiliar.idUsuario)
				.from(QAfinidad.afinidad)
				.where(QAfinidad.afinidad.afinidadUsuarioId.usuario_idusuario.idUsuario.eq(idUsuario))
			).and(QUsuario.usuario.tipousuario_idtipousuario.idTipoUsuario.eq(idTipoUsuario));
	}
	
	public static Predicate buscarFamiliarPorId(Integer idUsuario, Integer idParentesco) {
		return QUsuario.usuario.idUsuario.in(
				JPAExpressions
				.select(QAfinidad.afinidad.afinidadUsuarioId.idfamiliar.idUsuario)
				.from(QAfinidad.afinidad)
				.where(QAfinidad.afinidad.afinidadUsuarioId.usuario_idusuario.idUsuario.eq(idUsuario)))
				.and(QUsuario.usuario.parentesco_idparentesco.idParentesco.eq(idParentesco));
	}
	
	public static Predicate buscarPorIdTipoUsuario(Integer idTipoUsuarioApl, Integer idTipoUsuarioSis) {
		return QUsuario.usuario.tipousuario_idtipousuario.idTipoUsuario.in(idTipoUsuarioApl,idTipoUsuarioSis);
	}
	
	public static void cambiarEstadoUsuario(EntityManager entityManager, Integer idUsuario, Integer idEstado) {
		JPQLQueryFactory jpqlQueryFactory = new JPAQueryFactory(entityManager);
		jpqlQueryFactory.update(QUsuario.usuario)
		.set(QUsuario.usuario.estado_idestado.idEstado, idEstado)
		.where(QUsuario.usuario.idUsuario.eq(idUsuario))
		.execute();
	}
	
}
