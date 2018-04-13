package com.olonte.softipac.predicado;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.olonte.softipac.modelo.QAfinidad;
import com.olonte.softipac.modelo.QCita;
import com.olonte.softipac.modelo.QDocumento;
import com.olonte.softipac.modelo.QEps;
import com.olonte.softipac.modelo.QEscolaridad;
import com.olonte.softipac.modelo.QUsuario;
import com.olonte.softipac.modelo.RegistroListaAgenda;
import com.olonte.softipac.modelo.RegistroListaCitaInformacion;
import com.olonte.softipac.utilidad.Parametro;
import com.olonte.softipac.utilidad.Utilidad;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.JPQLQueryFactory;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

public class CitaPredicado {
	
	private CitaPredicado(){
	}
	
	public static Predicate buscarPorDocumento(String parametros) {
		
		Parametro parametro = new Parametro(parametros);
	
		return QCita.cita.citaId.usuario_idusuario.idUsuario.eq(
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
				).and(QCita.cita.citaId.tipocita_idtipocita.idTipoCita.in(parametro.getIds()));
	}
	
	public static List<RegistroListaAgenda> buscarCitasAgenda(EntityManager entityManager) {
		QCita qCita = new QCita("cita");
		QUsuario qPaciente = new QUsuario("paciente");
		QUsuario qAcudiente = new QUsuario("acudiente");
		QAfinidad qAfinidad = new QAfinidad("afinidad");
		ArrayList<RegistroListaAgenda> registrosListadoAgenda = new ArrayList<RegistroListaAgenda>();
		
		JPAQuery<Tuple> jpaQuery = new JPAQuery<>(entityManager);
		
		List<Tuple> listaAgendas = jpaQuery.select(	qCita.citaId.idcita,
													qCita.citaId.tipocita_idtipocita.idTipoCita,
													qCita.fechaCitaIni,
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
													.on(qCita.citaId.usuario_idusuario.idUsuario.eq(qPaciente.idUsuario))
											.where(qCita.citaId.tipocita_idtipocita.idTipoCita.eq(Utilidad.CITA_AGENDA)
											.and(qCita.citaId.estado_idestado.idEstado.eq(Utilidad.ESTADO_INACTIVO))
											.and(qAcudiente.tipousuario_idtipousuario.idTipoUsuario.eq(Utilidad.USUARIO_ACUDIENTE)))
											.orderBy(qCita.fechaCitaIni.asc(),qCita.hora.horaId.idhora.asc()).fetch();
		
		for (Tuple tuple : listaAgendas) {
			RegistroListaAgenda registroListaAgenda = new RegistroListaAgenda(tuple.get(qCita.citaId.idcita),
					tuple.get(qCita.citaId.tipocita_idtipocita.idTipoCita),
					tuple.get(qCita.fechaCitaIni),
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
	
	public static List<RegistroListaCitaInformacion> buscarCitasInformacion(EntityManager entityManager) {
		
		QDocumento qDocumento     = new QDocumento("documento");
		QUsuario qPaciente        = new QUsuario("paciente");
		QUsuario qAcudiente       = new QUsuario("acudiente");
		QEps qEps                 = new QEps("eps");
		QEscolaridad qEscolaridad = new QEscolaridad("escolaridad");
		QAfinidad qAfinidad   	  = new QAfinidad("afinidad");
		QCita qCita           	  = new QCita("cita");
		
		ArrayList<RegistroListaCitaInformacion> registrosListaCitaInformacion = new ArrayList<>();
		
		JPAQuery<Tuple> jpaQuery = new JPAQuery<>(entityManager);
		
		List<Tuple> listaCitasInformacion = jpaQuery.select(qCita.citaId.idcita,
															qCita.citaId.tipocita_idtipocita.idTipoCita,
															qDocumento.documento,
															qPaciente.idUsuario,
															qPaciente.nombres,
															qPaciente.primerApellido,
															qEps.razonSocial,
															qEscolaridad.escolaridad,
															qAcudiente.telefonoCelular)
													.from(qPaciente)
														.join(qAfinidad)
															.on(qAfinidad.afinidadUsuarioId.usuario_idusuario.idUsuario.eq(qPaciente.idUsuario))
														.join(qAcudiente)
															.on(qAfinidad.afinidadUsuarioId.idfamiliar.idUsuario.eq(qAcudiente.idUsuario))
														.join(qDocumento)
															.on(qDocumento.idDocumento.eq(qPaciente.documento_iddocumento.idDocumento))
														.join(qCita)
															.on(qCita.citaId.usuario_idusuario.idUsuario.eq(qPaciente.idUsuario))
														.join(qEps)
															.on(qEps.idEps.eq(qPaciente.eps_ideps.idEps))
														.join(qEscolaridad)
															.on(qEscolaridad.idEscolaridad.eq(qPaciente.escolaridad_idescolaridad.idEscolaridad))
													.where(qCita.citaId.tipocita_idtipocita.idTipoCita.eq(Utilidad.CITA_INFORMACION)
													.and(qCita.citaId.estado_idestado.idEstado.eq(Utilidad.ESTADO_PENDIENTE))
													.and(qPaciente.tipousuario_idtipousuario.idTipoUsuario.eq(Utilidad.USUARIO_PACIENTE))
													.and(qAcudiente.tipousuario_idtipousuario.idTipoUsuario.eq(Utilidad.USUARIO_ACUDIENTE)))
													.orderBy(qCita.citaId.idcita.asc()).fetch();
		for (Tuple tuple : listaCitasInformacion) {
			RegistroListaCitaInformacion registroListaCitaInformacion = new RegistroListaCitaInformacion(tuple.get(qCita.citaId.idcita),
					tuple.get(qCita.citaId.tipocita_idtipocita.idTipoCita),
					tuple.get(qDocumento.documento),
					tuple.get(qPaciente.idUsuario),
					tuple.get(qPaciente.nombres),
					tuple.get(qPaciente.primerApellido),
					tuple.get(qEps.razonSocial),
					tuple.get(qEscolaridad.escolaridad),
					tuple.get(qAcudiente.telefonoCelular));
			registrosListaCitaInformacion.add(registroListaCitaInformacion);
		}
		return registrosListaCitaInformacion;
	}
	
	public static Predicate buscarPorIdPaciente(Integer idUsuario, Integer idTipoCita) {
		return QCita.cita.citaId.usuario_idusuario.idUsuario.eq(
				JPAExpressions.
				select(QUsuario.usuario.idUsuario)
				.from(QUsuario.usuario)
				.where(QUsuario.usuario.idUsuario.eq(idUsuario)
						.and(QCita.cita.citaId.tipocita_idtipocita.idTipoCita.eq(idTipoCita))
					)
				);
	}
	
	public static void cambiarEstadoCita(EntityManager entityManager, Integer idcita, Integer idEstado) {
		JPQLQueryFactory jpqlQueryFactory = new JPAQueryFactory(entityManager);
		jpqlQueryFactory.update(QCita.cita)
		.set(QCita.cita.citaId.estado_idestado.idEstado, idEstado)
		.where(QCita.cita.citaId.idcita.eq(idcita))
		.execute();
	}
	
	
}
