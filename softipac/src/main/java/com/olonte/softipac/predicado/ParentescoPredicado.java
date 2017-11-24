package com.olonte.softipac.predicado;

import com.olonte.softipac.modelo.QParentesco;
import com.querydsl.core.types.Predicate;

public class ParentescoPredicado {
	
	private ParentescoPredicado() {
	}
	
	public static Predicate buscarTodos(Integer idParentesco) {
		return QParentesco.parentesco1.idParentesco.notIn(idParentesco);
	}
	
}
