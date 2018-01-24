package com.olonte.softipac.impl.servicio;

import java.time.LocalDate;
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
import com.olonte.softipac.modelo.TipoCita;
import com.olonte.softipac.modelo.Usuario;
import com.olonte.softipac.modelo.UsuarioSession;
import com.olonte.softipac.predicado.CitaPredicado;
import com.olonte.softipac.repositorio.CitaRepositorio;
import com.olonte.softipac.servicio.AfinidadServicio;
import com.olonte.softipac.servicio.CitaServicio;
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
	
	@Autowired
	public CitaImplServicio(CitaRepositorio citaRepositorio, TipoCitaServicio tipoCitaServicio,
			TipoUsuarioServicio tipoUsuarioServicio, ParentescoServicio parentescoServicio,
			EstadoServicio estadoServicio, UsuarioServicio usuarioServicio, AfinidadServicio afinidadServicio,
			TipoHoraServicio tipoHoraServicio, HoraServicio horaServicio, UsuarioSession usuarioSession) {
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
	}
	
	@Override
	@Transactional(readOnly = false)
	public void guardarActualizar(int tipoCita, int transaccion, Integer idEstado, Agenda agenda) {
		Estado estado_idestado = null;
		TipoCita tipocita_idtipocita =this.tipoCitaServicio.buscarPorId(tipoCita);
		if (transaccion == Utilidad.TRANS_GUARDAR) {
			 estado_idestado = this.estadoServicio.bucarporId(idEstado);
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
						agenda.getPaciente().setTipoUsuario(this.tipoUsuarioServicio.buscarPorId(Utilidad.USUARIO_PACIENTE));
						agenda.getPaciente().setEstado(estado_idestado);
						agenda.getPaciente().setParentesco(this.parentescoServicio.buscarPorId(Utilidad.HIJO));
						this.usuarioServicio.guardar(agenda.getPaciente());
						/** Acudiente */
						agenda.getAcudiente().setTipoUsuario(this.tipoUsuarioServicio.buscarPorId(Utilidad.USUARIO_ACUDIENTE));
						agenda.getAcudiente().setEstado(estado_idestado);
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
						 CitaId citaId = new CitaId(tipocita_idtipocita,estado_idestado,agenda.getPaciente(),this.usuarioSession);
						 agenda.getCita().setCitaId(citaId);
						 this.citaRepositorio.save(agenda.getCita());
						break;
					case Utilidad.TRANS_ACTUALIZAR:
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
						((CitaInformacion)agenda).getPaciente().setEstado(estado_idestado);	
						/**
						 * Si el usuario se crea por primera vez por medio de la cita de informacion
						 */
						if (((CitaInformacion)agenda).getPaciente().getIdUsuario() == null) {
							/**
							 * Se procesa los datos del paciente
							 */
							agenda.getPaciente().setTipoUsuario(this.tipoUsuarioServicio.buscarPorId(Utilidad.USUARIO_PACIENTE));
							agenda.getPaciente().setParentesco(this.parentescoServicio.buscarPorId(Utilidad.HIJO));
							this.usuarioServicio.guardar(agenda.getPaciente());
							/**
							 * Se procesa los datos de la Madre
							 */
							guardarUsuario(((CitaInformacion)agenda).getPaciente(),((CitaInformacion)agenda).getMadre(), Utilidad.USUARIO_PARIENTE, Utilidad.MADRE, estado_idestado);
							 
							/**
							 * Se procesa los datos del Padre
							 */
							guardarUsuario(((CitaInformacion)agenda).getPaciente(),((CitaInformacion)agenda).getPadre(), Utilidad.USUARIO_PARIENTE, Utilidad.PADRE, estado_idestado); 
							
							/**
							 * Se procesa los datos del Acudiente sino es ni la Madre ni el Padre
							 */
							if (((CitaInformacion)agenda).getAcudiente().getParentesco().getIdParentesco() != Utilidad.MADRE &&
									((CitaInformacion)agenda).getAcudiente().getParentesco().getIdParentesco() != Utilidad.PADRE) {					
								guardarUsuario(((CitaInformacion)agenda).getPaciente(),((CitaInformacion)agenda).getAcudiente(), Utilidad.USUARIO_PARIENTE, ((CitaInformacion)agenda).getAcudiente().getParentesco().getIdParentesco(), estado_idestado); 		
							}
						}else { /** El usuario ya ha sido creado por medio de la Agenda **/
							this.usuarioServicio.guardar(((CitaInformacion)agenda).getPaciente());
							/**
							 * Se procesa los datos de la Madre y el Padre si el Acudiente no es ninguno de los dos
							 */
							if (((CitaInformacion)agenda).getAcudiente().getParentesco().getIdParentesco() != Utilidad.MADRE &&
									((CitaInformacion)agenda).getAcudiente().getParentesco().getIdParentesco() != Utilidad.PADRE) {
								((CitaInformacion)agenda).getAcudiente().setEstado(estado_idestado);
								this.usuarioServicio.guardar(((CitaInformacion)agenda).getAcudiente());
								/**
								 * Se procesa los datos de la Madre
								 */
								 guardarUsuario(((CitaInformacion)agenda).getPaciente(), ((CitaInformacion)agenda).getMadre(), Utilidad.USUARIO_PARIENTE, Utilidad.MADRE, estado_idestado); 			
								/**
								 * Se procesa los datos del padre
								 */
								guardarUsuario(((CitaInformacion)agenda).getPaciente(),((CitaInformacion)agenda).getPadre(), Utilidad.USUARIO_PARIENTE, Utilidad.PADRE, estado_idestado); 								
							}else if (((CitaInformacion)agenda).getAcudiente().getParentesco().getIdParentesco() == Utilidad.MADRE) { /** El Acudiente no es ni la Madre ni el Padre */
								agenda.getAcudiente().setEstado(estado_idestado);                                          /**  y el Padre no se ha creado */
								this.usuarioServicio.guardar(agenda.getAcudiente());
								/**
								 * Se procesa los datos del padre
								 */
								 guardarUsuario(((CitaInformacion)agenda).getPaciente(),((CitaInformacion)agenda).getPadre(), Utilidad.USUARIO_PARIENTE, Utilidad.PADRE, estado_idestado); 	 
							}else if (((CitaInformacion)agenda).getAcudiente().getParentesco().getIdParentesco() == Utilidad.PADRE) { /** El Acudiente no es ni la Madre ni el Padre */
								((CitaInformacion)agenda).getAcudiente().setEstado(estado_idestado);										   /** y la Madre no se ha creado */	
								this.usuarioServicio.guardar(((CitaInformacion)agenda).getAcudiente());
								/**
								 * Se procesa los datos de la Madre
								 */
								 guardarUsuario(((CitaInformacion)agenda).getPaciente(),((CitaInformacion)agenda).getMadre(), Utilidad.USUARIO_PARIENTE, Utilidad.MADRE, estado_idestado); 					
							}
							CitaId citaId = new CitaId(tipocita_idtipocita,estado_idestado,((CitaInformacion)agenda).getPaciente(),this.usuarioSession);
							((CitaInformacion)agenda).getCita().setCitaId(citaId);
							this.citaRepositorio.save(((CitaInformacion)agenda).getCita());
							/**
							 * Se cambia el estadoa la cita tipo Agenda
							*/
							cambiarEstadoCita(((CitaInformacion)agenda).getPaciente().getIdUsuario(), Utilidad.CITA_AGENDA, Utilidad.ESTADO_TERMINADO);
						}
						
						break;
					case Utilidad.TRANS_ACTUALIZAR:
						break;
					default:
						break;
				}
				default:
					break;
		}
	
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
		familiar.setTipoUsuario(this.tipoUsuarioServicio.buscarPorId(tipoUsuario));
		if (tipoUsuario != Utilidad.USUARIO_ACUDIENTE) {
			familiar.setParentesco(this.parentescoServicio.buscarPorId(parentesco));
		}
		
		familiar.setEstado(estado);
		this.usuarioServicio.guardar(familiar);
		this.afinidadServicio.guardar(obtenerAfinidad(paciente, familiar));
	}

	@Override
	@Transactional(readOnly = true)
	public CitaJSON buscarPorDocumento(String documento) {
		CitaJSON citaJSON =  JSON.obtenerCitaJSON(this.citaRepositorio.findOne(CitaPredicado.buscarPorDocumento(documento)));
		citaJSON.getHoras().add(citaJSON.getHora());
		citaJSON.getHoras().addAll(this.horaServicio.buscarHoraPorDocumento(documento));
		return citaJSON;
	}
	
	@Override
	@Transactional(readOnly = true)
	public Agenda buscarUsuarioAgenda(Integer idUsuario, Integer idTipoUsuario, Integer idTipoCita) {
		Agenda agenda = new Agenda();
		agenda.setCita(buscarPorIdPaciente(idUsuario,idTipoCita));
		agenda.setPaciente(this.usuarioServicio.buscarPacientePorId(idUsuario));
		agenda.setAcudiente(this.usuarioServicio.buscarAcudientePorId(idUsuario,idTipoUsuario));
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
	public ArrayList<String> obtenerMeses() {
		ArrayList<String> meses = new ArrayList<>();
		meses.add("Seleccione");
		meses.add("1 Mes");
		meses.add("2 Meses");
		meses.add("3 Meses");
		meses.add("4 Meses");
		meses.add("5 Meses");
		meses.add("6 Meses");
		meses.add("7 Meses");
		meses.add("8 Meses");
		meses.add("9 Meses");
		meses.add("10 Meses");
		meses.add("11 Meses");
		return meses;
	}

	@Override
	@Transactional(readOnly = false)
	public void cambiarEstadoCita(Integer idUsuario, Integer idTipoCita, Integer idEstado) {
		CitaPredicado.cambiarEstadoCita(entityManager, idUsuario, idTipoCita, idEstado);
	}

	@Override
	@Transactional(readOnly = true)
	public List<RegistroListaAgenda> buscarTodos() {
		return CitaPredicado.buscarCitas(entityManager);
	}

	@Override
	@Transactional(readOnly = true)
	public LocalDate obtenerFechaCitaIni(Integer idUsuario, Integer idTipoCita) {
		return this.citaRepositorio.findOne(CitaPredicado.buscarPorIdPaciente(idUsuario,idTipoCita)).getFechaCitaIni();
	}

}
