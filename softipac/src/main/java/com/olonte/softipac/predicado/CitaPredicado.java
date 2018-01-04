package com.olonte.softipac.predicado;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.olonte.softipac.modelo.QAfinidad;
import com.olonte.softipac.modelo.QCita;
import com.olonte.softipac.modelo.QDocumento;
import com.olonte.softipac.modelo.QUsuario;
import com.olonte.softipac.modelo.RegistroListaAgenda;
import com.olonte.softipac.utilidad.Utilidad;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQuery;

public class CitaPredicado {
	
	private CitaPredicado(){
	}
	
	public static Predicate buscarPorDocumento(String documento) {
		return QCita.cita.citaUsuarioId.usuario_idusuario.idUsuario.eq(JPAExpressions
				.select(QUsuario.usuario.idUsuario)
				.from(QUsuario.usuario)
				.where(QUsuario.usuario.documento.idDocumento.eq(JPAExpressions
						.select(QDocumento.documento1.idDocumento)
						.from(QDocumento.documento1)
						.where(QDocumento.documento1.documento.eq(documento) ) ) ) );
	}
	
	//public static Iterable<RegistroListaAgenda> buscarCitas(EntityManager entityManager) {
	public static List<RegistroListaAgenda> buscarCitas(EntityManager entityManager) {
		QCita qCita = new QCita("cita");
		QUsuario qPaciente = new QUsuario("paciente");
		QUsuario qAcudiente = new QUsuario("acudiente");
		QAfinidad qAfinidad = new QAfinidad("afinidad");
		ArrayList<RegistroListaAgenda> registrosListadoAgenda = new ArrayList<RegistroListaAgenda>();
		
		JPAQuery<Tuple> jpaQuery = new JPAQuery<>(entityManager);
		
		List<Tuple> listaAgendas = jpaQuery.select( qCita.fechaCitaIni,
													 qCita.hora.hora,
													 qPaciente.idUsuario,
													 qPaciente.nombres,
													 qPaciente.primerApellido,
													 qAcudiente.telefonoFijo,
													 qAcudiente.telefonoCelular)
											.from(qPaciente)
												.join(qAfinidad)
													.on(qAfinidad.afinidadUsuarioId.usuario_idusuario.idUsuario.eq(qPaciente.idUsuario))
												.join(qAcudiente)
													.on(qAfinidad.afinidadUsuarioId.idfamiliar.idUsuario.eq(qAcudiente.idUsuario))
												.join(qCita)
													.on(qCita.citaUsuarioId.usuario_idusuario.idUsuario.eq(qPaciente.idUsuario))
											.where(qCita.tipoCita.idTipoCita.eq(Utilidad.CITA_AGENDA)
											.and(qCita.estado.idEstado.eq(Utilidad.ESTADO_INACTIVO))
											.and(qAcudiente.tipoUsuario.idTipoUsuario.eq(Utilidad.USUARIO_ACUDIENTE)))
											.orderBy(qCita.fechaCitaIni.asc(),qCita.hora.idHora.asc()).fetch();
	  
		for (Tuple tuple : listaAgendas) {
			RegistroListaAgenda registroListaAgenda = new RegistroListaAgenda(tuple.get(qCita.fechaCitaIni),
					tuple.get(qCita.hora.hora),
					tuple.get(qPaciente.idUsuario),
					tuple.get(qPaciente.nombres),
					tuple.get(qPaciente.primerApellido),
					tuple.get(qAcudiente.telefonoFijo),
					tuple.get(qAcudiente.telefonoCelular));
			registrosListadoAgenda.add(registroListaAgenda);
	      }
		return registrosListadoAgenda;	
	}
	
	public static Predicate buscarPorIdPaciente(Integer idUsuario) {
		return QCita.cita.citaUsuarioId.usuario_idusuario.idUsuario.eq(JPAExpressions.
				select(QUsuario.usuario.idUsuario)
				.from(QUsuario.usuario)
				.where(QUsuario.usuario.idUsuario.eq(idUsuario)
						.and(QCita.cita.tipoCita.idTipoCita.eq(Utilidad.CITA_AGENDA))));
	}
	
}
