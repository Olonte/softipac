package com.olonte.softipac.predicado;

import com.olonte.softipac.modelo.QTipoUsuario;
import com.olonte.softipac.utilidad.Utilidad;
import com.querydsl.core.types.Predicate;

public class TipoUsuarioPredicado {
	
	private TipoUsuarioPredicado() {
	}
	
	public static Predicate buscarTodos() {
		return QTipoUsuario.tipoUsuario.idTipoUsuario.in(Utilidad.USUARIO_APLICACION, Utilidad.USUARIO_SISTEMA);
	}
}
