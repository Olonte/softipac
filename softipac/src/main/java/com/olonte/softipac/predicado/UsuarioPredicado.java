package com.olonte.softipac.predicado;

import com.olonte.softipac.modelo.QUsuario;
import com.querydsl.core.types.Predicate;

public class UsuarioPredicado {
	
	private UsuarioPredicado() {
	}
	
	public static Predicate buscarUsuarioPredicado(String nombreUsuario) {
		return QUsuario.usuario.nomnbreUsuario.eq(nombreUsuario);
	}

}
