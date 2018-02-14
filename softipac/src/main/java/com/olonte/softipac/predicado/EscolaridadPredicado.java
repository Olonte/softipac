package com.olonte.softipac.predicado;

import com.olonte.softipac.modelo.QEscolaridad;
import com.olonte.softipac.utilidad.Utilidad;
import com.querydsl.core.types.Predicate;

public class EscolaridadPredicado {
	
	private EscolaridadPredicado(){
	}
	
	public static Predicate buscarEscolaridadesUsuario() {
		return QEscolaridad.escolaridad1.idEscolaridad.notIn(Utilidad.JARDIN, Utilidad.INCLUSION_ESCOLAR);
	}
}
