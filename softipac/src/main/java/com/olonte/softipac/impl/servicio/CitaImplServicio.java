package com.olonte.softipac.impl.servicio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olonte.softipac.json.CitaJSON;
import com.olonte.softipac.json.JSON;
import com.olonte.softipac.modelo.Afinidad;
import com.olonte.softipac.modelo.AfinidadUsuarioId;
import com.olonte.softipac.modelo.Agenda;
import com.olonte.softipac.modelo.Cita;
import com.olonte.softipac.modelo.CitaId;
import com.olonte.softipac.modelo.CitaInformacion;
import com.olonte.softipac.modelo.Estado;
import com.olonte.softipac.modelo.Hora;
import com.olonte.softipac.modelo.RegistroListaAgenda;
import com.olonte.softipac.modelo.RegistroListaCitaInformacion;
import com.olonte.softipac.modelo.TipoCita;
import com.olonte.softipac.modelo.Usuario;
import com.olonte.softipac.modelo.UsuarioSession;
import com.olonte.softipac.predicado.CitaPredicado;
import com.olonte.softipac.repositorio.CitaRepositorio;
import com.olonte.softipac.servicio.AfinidadServicio;
import com.olonte.softipac.servicio.CitaServicio;
import com.olonte.softipac.servicio.DiagnosticoServcio;
import com.olonte.softipac.servicio.EstadoServicio;
import com.olonte.softipac.servicio.HoraServicio;
import com.olonte.softipac.servicio.ParentescoServicio;
import com.olonte.softipac.servicio.TipoCitaServicio;
import com.olonte.softipac.servicio.TipoHoraServicio;
import com.olonte.softipac.servicio.TipoUsuarioServicio;
import com.olonte.softipac.servicio.UsuarioServicio;
import com.olonte.softipac.utilidad.Utilidad;

@Service
@Scope(value = "session")
public class CitaImplServicio implements CitaServicio {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	private CitaRepositorio citaRepositorio;
	
	private TipoCitaServicio tipoCitaServicio;
	
	private TipoUsuarioServicio tipoUsuarioServicio;
	
	private ParentescoServicio parentescoServicio;
	
	private EstadoServicio estadoServicio;
	
	private UsuarioServicio usuarioServicio;
	
	private AfinidadServicio afinidadServicio;
	
	private TipoHoraServicio tipoHoraServicio;
	
	private HoraServicio horaServicio;
	
	private UsuarioSession usuarioSession;
	
	private DiagnosticoServcio diagnosticoServicio;
	
	@Autowired
	public CitaImplServicio(CitaRepositorio citaRepositorio, TipoCitaServicio tipoCitaServicio,
			TipoUsuarioServicio tipoUsuarioServicio, ParentescoServicio parentescoServicio,
			EstadoServicio estadoServicio, UsuarioServicio usuarioServicio, AfinidadServicio afinidadServicio,
			TipoHoraServicio tipoHoraServicio, HoraServicio horaServicio, UsuarioSession usuarioSession,
			DiagnosticoServcio diagnosticoServicio) {
		this.citaRepositorio = citaRepositorio;
		this.tipoCitaServicio = tipoCitaServicio;
		this.tipoUsuarioServicio = tipoUsuarioServicio;
		this.parentescoServicio = parentescoServicio;
		this.estadoServicio = estadoServicio;
		this.usuarioServicio = usuarioServicio;
		this.afinidadServicio = afinidadServicio;
		this.tipoHoraServicio = tipoHoraServicio;
		this.horaServicio = horaServicio;
		this.usuarioSession = usuarioSession;
		this.diagnosticoServicio = diagnosticoServicio;
	}

	@Override
	@Transactional(readOnly = false)
	public void guardarActualizar(int tipoCita, int transaccion, Integer idEstado, Agenda agenda) {
		Estado estado_idestado_cita = null;
		Estado estado_idestado_usuario = null;
		TipoCita tipocita_idtipocita =this.tipoCitaServicio.buscarPorId(tipoCita);
		if (transaccion == Utilidad.TRANS_GUARDAR) {
			estado_idestado_cita = this.estadoServicio.buscarporId(idEstado);
			estado_idestado_usuario = this.estadoServicio.buscarporId(Utilidad.ESTADO_INACTIVO);
			 
		}
		switch (tipoCita) {
			case Utilidad.CITA_AGENDA:
				switch (transaccion) {
					case Utilidad.TRANS_GUARDAR:
						/**
						 * Se procesa el Paciente y el Acudiente
						 * 
						 */
						/** Paciente */
						agenda.getPaciente().setTipousuario_idtipousuario((this.tipoUsuarioServicio.buscarPorId(Utilidad.USUARIO_PACIENTE)));
						agenda.getPaciente().setEstado_idestado(estado_idestado_usuario);
						agenda.getPaciente().setParentesco_idparentesco(this.parentescoServicio.buscarPorId(Utilidad.HIJO));
						this.usuarioServicio.guardar(agenda.getPaciente());
						/** Acudiente */
						agenda.getAcudiente().setTipousuario_idtipousuario(this.tipoUsuarioServicio.buscarPorId(Utilidad.USUARIO_ACUDIENTE));
						agenda.getAcudiente().setEstado_idestado(estado_idestado_usuario);
						this.usuarioServicio.guardar(agenda.getAcudiente());
						 /*
						 * Se procesa la Afinidad
						 */
						 AfinidadUsuarioId afinidadUsuarioId = new AfinidadUsuarioId();
						 Afinidad afinidad = new Afinidad();
						 afinidadUsuarioId.setUsuario_idusuario(agenda.getPaciente());
						 afinidadUsuarioId.setIdfamiliar(agenda.getAcudiente());
						 afinidad.setAfinidadUsuarioId(afinidadUsuarioId);
						 this.afinidadServicio.guardar(afinidad);
						 
						 agenda.getCita().getHora().getHoraId().setTipohora_idtipohora(this.tipoHoraServicio.buscarPorId(Utilidad.CITA_AGENDA));
						/**
						 * Se procesa la Cita
						 */
						 CitaId citaId = new CitaId(tipocita_idtipocita,estado_idestado_cita,agenda.getPaciente(),this.usuarioSession);
						 agenda.getCita().setCitaId(citaId);
						 this.citaRepositorio.save(agenda.getCita());
						break;
					case Utilidad.TRANS_ACTUALIZAR:
						if (agenda.isJavaScript()) {
							guardarDiagnosticos(agenda);
						}
						this.usuarioServicio.guardar(agenda.getPaciente());
						this.usuarioServicio.guardar(agenda.getAcudiente());
						this.citaRepositorio.save(agenda.getCita());
						break;
					default:
						break;
				}
				break;
			case Utilidad.CITA_INFORMACION:
				switch (transaccion) {
					case Utilidad.TRANS_GUARDAR:
						((CitaInformacion)agenda).getPaciente().setEstado_idestado(estado_idestado_cita);	
						Integer idTipoUsuario = Utilidad.USUARIO_PARIENTE;
						/**
						 * Si el usuario se crea por primera vez por medio de la cita de informacion
						 */
						if (((CitaInformacion)agenda).getPaciente().getIdUsuario() == null) {
							/**
							 * Se procesa los datos del paciente
							 */
							((CitaInformacion)agenda).getPaciente().setTipousuario_idtipousuario(this.tipoUsuarioServicio.buscarPorId(Utilidad.USUARIO_PACIENTE));
							((CitaInformacion)agenda).getPaciente().setParentesco_idparentesco(this.parentescoServicio.buscarPorId(Utilidad.HIJO));
							
							this.usuarioServicio.guardar(((CitaInformacion)agenda).getPaciente());
							/**
							 * Se procesa los datos de la Madre
							 */
							/**
							 * Si la Madre es el Acudiente
							 */
							if (((CitaInformacion)agenda).getAcudiente().getParentesco_idparentesco().getIdParentesco() == Utilidad.MADRE) {
								idTipoUsuario = Utilidad.USUARIO_ACUDIENTE;
							}
							guardarUsuario(((CitaInformacion)agenda).getPaciente(), ((CitaInformacion)agenda).getMadre(), idTipoUsuario, Utilidad.MADRE, estado_idestado_usuario);
							idTipoUsuario = Utilidad.USUARIO_PARIENTE; 
							/**
							 * Se procesa los datos del Padre
							 */
							/**
							 * Si el Padre es el Acudiente
							 */
							if (((CitaInformacion)agenda).getAcudiente().getParentesco_idparentesco().getIdParentesco() == Utilidad.PADRE) {
								idTipoUsuario = Utilidad.USUARIO_ACUDIENTE;
							}
							guardarUsuario(((CitaInformacion)agenda).getPaciente(),((CitaInformacion)agenda).getPadre(), idTipoUsuario, Utilidad.PADRE, estado_idestado_usuario); 
							
							/**
							 * Se procesa los datos del Acudiente sino es ni la Madre ni el Padre
							 */
							if (((CitaInformacion)agenda).getAcudiente().getParentesco_idparentesco().getIdParentesco() != Utilidad.MADRE &&
									((CitaInformacion)agenda).getAcudiente().getParentesco_idparentesco().getIdParentesco() != Utilidad.PADRE) {					
								guardarUsuario(((CitaInformacion)agenda).getPaciente(), ((CitaInformacion)agenda).getAcudiente(), Utilidad.USUARIO_ACUDIENTE, ((CitaInformacion)agenda).getAcudiente().getParentesco_idparentesco().getIdParentesco(), estado_idestado_usuario); 		
							}
							/**
							 * Se procesa la cita
							 */
							guardarCita(((CitaInformacion)agenda), tipocita_idtipocita, estado_idestado_cita);
						}else { /** El usuario ya ha sido creado por medio de la Agenda **/
							/**
							 * Se procesa los datos del paciente
							 */
							this.usuarioServicio.guardar(((CitaInformacion)agenda).getPaciente());
							/**
							 * Si el Acudiente no es ni la Madre ni el Padre 
							 */
							if (((CitaInformacion)agenda).getAcudiente().getParentesco_idparentesco().getIdParentesco() != Utilidad.MADRE &&
									((CitaInformacion)agenda).getAcudiente().getParentesco_idparentesco().getIdParentesco() != Utilidad.PADRE) {
								((CitaInformacion)agenda).getAcudiente().setEstado_idestado(estado_idestado_usuario);
								this.usuarioServicio.guardar(((CitaInformacion)agenda).getAcudiente());
								/**
								* Se procesa los datos de la Madre
								*/
								guardarUsuario(((CitaInformacion)agenda).getPaciente(),((CitaInformacion)agenda).getMadre(), Utilidad.USUARIO_PARIENTE, Utilidad.MADRE, estado_idestado_usuario);
								/**
								* Se procesa los datos del Padre
								*/
								guardarUsuario(((CitaInformacion)agenda).getPaciente(),((CitaInformacion)agenda).getPadre(), Utilidad.USUARIO_PARIENTE, Utilidad.PADRE, estado_idestado_usuario);								
							/**
							 * Si el Acudiente es la Madre 	
							 */
							}else if (((CitaInformacion)agenda).getAcudiente().getParentesco_idparentesco().getIdParentesco() == Utilidad.MADRE) {
								/**
								 * Se actualizan los datos de la Madre
								 */
								this.usuarioServicio.guardar(((CitaInformacion)agenda).getMadre());
								/**
								* Se procesa los datos del Padre
								*/
								guardarUsuario(((CitaInformacion)agenda).getPaciente(),((CitaInformacion)agenda).getPadre(), Utilidad.USUARIO_PARIENTE, Utilidad.PADRE, estado_idestado_usuario); 		
							/**
							 * Si el Acudiente es el Padre	
							 */
							}else if (((CitaInformacion)agenda).getAcudiente().getParentesco_idparentesco().getIdParentesco() == Utilidad.PADRE) {
								/**
								 * Se actualizan los datos de la Padre
								 */
								this.usuarioServicio.guardar(((CitaInformacion)agenda).getPadre());
								/**
								* Se procesa los datos del Madre
								*/
								guardarUsuario(((CitaInformacion)agenda).getPaciente(),((CitaInformacion)agenda).getMadre(), Utilidad.USUARIO_PARIENTE, Utilidad.MADRE, estado_idestado_usuario); 								
							}							
							/**
							 * Se procesa la cita
							 */
							guardarCita(((CitaInformacion)agenda), tipocita_idtipocita, estado_idestado_cita);
							/**
							 * Se cambia el estadoa la cita tipo Agenda
							*/
							//cambiarEstadoCita(((CitaInformacion)agenda).getPaciente().getIdUsuario(), Utilidad.CITA_AGENDA, Utilidad.ESTADO_TERMINADO);
							Integer idCita = agenda.getCita().getCitaId().getIdcita();
							//cambiarEstadoCita(((CitaInformacion)agenda).getCita().getCitaId().getIdcita(), Utilidad.ESTADO_TERMINADO);
							cambiarEstadoCita(idCita, Utilidad.ESTADO_TERMINADO);
						}
						break;
					case Utilidad.TRANS_ACTUALIZAR:
						if (((CitaInformacion)agenda).isJavaScript()) {
							guardarDiagnosticos(agenda);
						}
						/**
						 * Se actualizan los datos del paciente
						 */
						this.usuarioServicio.guardar(((CitaInformacion)agenda).getPaciente());
						/**
						 * Se actualizan los datos de  el Acudiente sino es ni la Madre ni el Padre
						 */
						if (((CitaInformacion)agenda).getAcudiente().getParentesco_idparentesco().getIdParentesco() != Utilidad.MADRE && 
								((CitaInformacion)agenda).getAcudiente().getParentesco_idparentesco().getIdParentesco() != Utilidad.PADRE) {
							this.usuarioServicio.guardar(((CitaInformacion)agenda).getAcudiente());
						}
						/**
						 * Se actualizan los datos de la Madre
						 */
						this.usuarioServicio.guardar(((CitaInformacion)agenda).getMadre());
						/**
						 * Se actualizan los datos del Padre
						 */
						this.usuarioServicio.guardar(((CitaInformacion)agenda).getPadre());
						/**
						 * Se actualizan los datos de la cita
						 */
						this.citaRepositorio.save(((CitaInformacion)agenda).getCita());
						break;
					default:
						break;
				}
				default:
					break;
		}
	
	}

	@Override
	@Transactional(readOnly = true)
	public CitaJSON buscarPorDocumento(String parametros) {
		CitaJSON citaJSON =  JSON.obtenerCitaJSON(this.citaRepositorio.findOne(CitaPredicado.buscarPorDocumento(parametros)));
		if (Integer.parseInt(parametros.substring(parametros.indexOf(Utilidad.SEPARADOR) + 1, parametros.length())) == Utilidad.CITA_AGENDA) {
			citaJSON.getHoras().add(citaJSON.getHora());
			citaJSON.getHoras().addAll(this.horaServicio.buscarHoraPorDocumento(parametros));
		}
		return citaJSON;
	}
	
	@Override
	@Transactional(readOnly = true)
	public Agenda buscarUsuarioAgenda(Integer idUsuario, Integer idTipoUsuario, Integer idTipoCita) {
		Agenda agenda = new Agenda();				
		agenda.setCita(buscarPorIdPaciente(idUsuario,idTipoCita));		
		agenda.setPaciente(this.usuarioServicio.buscarPorId(agenda.getCita().getCitaId().getUsuario_idusuario()));		
		agenda.setAcudiente(this.usuarioServicio.buscarAcudientePorId(agenda.getPaciente()));
		return agenda;
	}

	@Override
	@Transactional(readOnly = true)
	public Cita buscarPorIdPaciente(Integer idUsuario, Integer idTipoCita) {
		return this.citaRepositorio.findOne(CitaPredicado.buscarPorIdPaciente(idUsuario,idTipoCita));
	}

	@Override
	@Transactional(readOnly = true)
	public ArrayList<Hora> obtenerHoras(Agenda agenda, Integer idTipoHora) {
		ArrayList<Hora> horas = new ArrayList<Hora>();
		horas.add(agenda.getCita().getHora());
		horas.addAll((Collection<? extends Hora>) this.horaServicio.buscarAgendaPorFecha(agenda.getCita().getFechaCitaIni(),Utilidad.CITA_AGENDA,idTipoHora));
		return horas;
	}

	@Override
	@Transactional(readOnly = false)
	public void cambiarEstadoCita(Integer idcita, Integer idEstado) {
		CitaPredicado.cambiarEstadoCita(entityManager, idcita, idEstado);
	}

	@Override
	@Transactional(readOnly = true)
	public List<RegistroListaAgenda> buscarCitasAgenda() {
		return CitaPredicado.buscarCitasAgenda(entityManager);
	}

	@Override
	@Transactional(readOnly = true)
	public List<RegistroListaCitaInformacion> buscarCitasInformacion() {
		return CitaPredicado.buscarCitasInformacion(entityManager);
	}
	
	private Afinidad obtenerAfinidad(Usuario paciente, Usuario familiar) {
		 AfinidadUsuarioId afinidadUsuarioId = new AfinidadUsuarioId();
		 Afinidad afinidad = new Afinidad();
		 afinidadUsuarioId.setUsuario_idusuario(paciente);
		 afinidadUsuarioId.setIdfamiliar(familiar);
		 afinidad.setAfinidadUsuarioId(afinidadUsuarioId);
		 return afinidad;
	}
	
	@Transactional(readOnly = false)
	private void guardarUsuario(Usuario paciente, Usuario familiar, Integer tipoUsuario, Integer parentesco, Estado estado) {
		familiar.setTipousuario_idtipousuario(this.tipoUsuarioServicio.buscarPorId(tipoUsuario));
		if (parentesco == Utilidad.MADRE || parentesco == Utilidad.PADRE ) {
			familiar.setParentesco_idparentesco(this.parentescoServicio.buscarPorId(parentesco));
		}
		
		familiar.setEstado_idestado(estado);
		this.usuarioServicio.guardar(familiar);
		this.afinidadServicio.guardar(obtenerAfinidad(paciente, familiar));
	}
	
	@Transactional(readOnly = false)
	private void guardarCita(CitaInformacion citaInformacion, TipoCita tipocita_idtipocita, Estado estado_idestado) {
		CitaId citaId = new CitaId(tipocita_idtipocita,estado_idestado,citaInformacion.getPaciente(),this.usuarioSession);
		citaInformacion.getCita().setCitaId(citaId);
		this.citaRepositorio.save(citaInformacion.getCita());
		
	}
	
	private void guardarDiagnosticos(Agenda agenda) {
		if (agenda.getPaciente().getDiagnosticos().isEmpty()) {
			agenda.getPaciente().setDiagnosticos(this.diagnosticoServicio.buscarPorIdUsuario(agenda.getPaciente().getIdUsuario()));
		}else {
			agenda.getPaciente().getDiagnosticos().addAll(this.diagnosticoServicio.buscarPorIdUsuario(agenda.getPaciente().getIdUsuario()));
		}
	}

}
