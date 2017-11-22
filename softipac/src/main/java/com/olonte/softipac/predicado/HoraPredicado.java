package com.olonte.softipac.predicado;

import java.time.LocalDate;

import com.olonte.softipac.modelo.QCita;
import com.olonte.softipac.modelo.QHora;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.JPAExpressions;

public class HoraPredicado {
	
	private HoraPredicado() {
	}
	
	public static Predicate buscarPorFecha(LocalDate fecha) {
		return QHora.hora1.idHora.notIn(JPAExpressions.select(QCita.cita.hora.idHora)
				.from(QCita.cita)
				.where(QCita.cita.fechaCitaIni.eq(fecha)));
	}

}
