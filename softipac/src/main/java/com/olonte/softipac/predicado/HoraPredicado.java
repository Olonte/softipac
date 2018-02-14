package com.olonte.softipac.predicado;

import java.time.LocalDate;

import com.olonte.softipac.modelo.QCita;
import com.olonte.softipac.modelo.QDocumento;
import com.olonte.softipac.modelo.QHora;
import com.olonte.softipac.modelo.QUsuario;
import com.olonte.softipac.utilidad.Parametro;
import com.olonte.softipac.utilidad.Utilidad;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.JPAExpressions;

public class HoraPredicado {
	
	private HoraPredicado() {
	}
	
	public static Predicate buscarAgendaPorFecha(LocalDate fecha, Integer idTipoCita, Integer idTipoHora) {
		
		return QHora.hora1.horaId.idhora.notIn(
				JPAExpressions
				.select(QCita.cita.hora.horaId.idhora)
				.from(QCita.cita)
				.where(QCita.cita.fechaCitaIni.eq(fecha)
						.and(QCita.cita.citaId.tipocita_idtipocita.idTipoCita.eq(idTipoCita)) 
						)
				)
				.and(QHora.hora1.horaId.tipohora_idtipohora.idTipoHora.eq(idTipoHora));	
		
	}
	
	public static Predicate buscarHorasPorDocumento(String parametros) {
		
		Parametro parametro = new Parametro(parametros);
		
		return QHora.hora1.horaId.idhora.notIn(
				JPAExpressions
				.select(QCita.cita.hora.horaId.idhora)
				.from(QCita.cita)
				.where(QCita.cita.fechaCitaIni.eq(
						JPAExpressions
						.select(QCita.cita.fechaCitaIni)
						.from(QCita.cita)
						.where(QCita.cita.citaId.usuario_idusuario.idUsuario.eq(
								JPAExpressions
								.select(QUsuario.usuario.idUsuario)
								.from(QUsuario.usuario)
								.where(QUsuario.usuario.documento_iddocumento.idDocumento.in(
										JPAExpressions
										.select(QDocumento.documento1.idDocumento)
										.from(QDocumento.documento1)
										.where(QDocumento.documento1.documento.eq(parametro.getDocumento()))
										).and(QUsuario.usuario.tipousuario_idtipousuario.idTipoUsuario.eq(Utilidad.USUARIO_PACIENTE))
									)
								).and(QCita.cita.citaId.tipocita_idtipocita.idTipoCita.in(parametro.getIds()))
							)
						).and(QHora.hora1.horaId.tipohora_idtipohora.idTipoHora.eq(Utilidad.HORA_AGENDA) ) ) 
				).and(QHora.hora1.horaId.tipohora_idtipohora.idTipoHora.eq(Utilidad.HORA_AGENDA));
	}
	
	public static Predicate bucarEvaluacionPorFecha(LocalDate fecha){
		return null;
	}

}
