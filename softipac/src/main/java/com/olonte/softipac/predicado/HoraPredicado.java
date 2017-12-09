package com.olonte.softipac.predicado;

import java.time.LocalDate;

import com.olonte.softipac.modelo.QCita;
import com.olonte.softipac.modelo.QHora;
import com.olonte.softipac.utilidad.Utilidad;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.JPAExpressions;

public class HoraPredicado {
	
	private HoraPredicado() {
	}
	
	public static Predicate buscarAgendaPorFecha(LocalDate fecha) {
		return QHora.hora1.idHora.notIn(JPAExpressions.select(QCita.cita.hora.idHora)
				.from(QCita.cita)
				.where(QCita.cita.fechaCitaIni.eq(fecha)
						.and(QHora.hora1.tipoHora.idTipoHora.eq(Utilidad.HORA_AGENDA))));
	}
	
	public static Predicate bucarEvaluacionPorFecha(LocalDate fecha){
		return null;
	}

}
