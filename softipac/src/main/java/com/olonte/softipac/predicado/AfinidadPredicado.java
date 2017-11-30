package com.olonte.softipac.predicado;

import com.olonte.softipac.modelo.QAfinidad;
import com.querydsl.core.types.Predicate;

public class AfinidadPredicado {
	
	private AfinidadPredicado(){
	}
	
	public static Predicate buscarPorIdPaciente(Integer idPaciente) {
		return QAfinidad.afinidad.afinidadUsuarioId.usuario_idusuario.idUsuario.eq(idPaciente);
	}

}
