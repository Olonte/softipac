package com.olonte.softipac.predicado;

import com.olonte.softipac.modelo.QTipoCita;
import com.querydsl.core.types.Predicate;

public class TipoCitaPredicado {
	
	private TipoCitaPredicado() {
	}
	
	public static Predicate	 buscarPorId(int idTipoCita) {
		return QTipoCita.tipoCita.idTipoCita.eq(idTipoCita);
	}
	
}
