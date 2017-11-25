package com.olonte.softipac.impl.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olonte.softipac.modelo.Agenda;
import com.olonte.softipac.modelo.Cita;
import com.olonte.softipac.modelo.CitaUsuarioId;
import com.olonte.softipac.modelo.Estado;
import com.olonte.softipac.modelo.UsuarioSession;
import com.olonte.softipac.predicado.CitaPredicado;
import com.olonte.softipac.repositorio.CitaRepositorio;
import com.olonte.softipac.servicio.CitaServicio;
import com.olonte.softipac.servicio.EstadoServicio;
import com.olonte.softipac.servicio.ParentescoServicio;
import com.olonte.softipac.servicio.TipoCitaServicio;
import com.olonte.softipac.servicio.TipoUsuarioServicio;
import com.olonte.softipac.servicio.UsuarioServcio;

@Service
@Scope(value = "session")
public class CitaImplServicio implements CitaServicio {
	
	private CitaRepositorio citaRepositorio;
	
	private TipoCitaServicio tipoCitaServicio;
	
	private TipoUsuarioServicio tipoUsuarioServicio;
	
	private ParentescoServicio parentescoServicio;
	
	private EstadoServicio estadoServicio;
	
	private UsuarioServcio usuarioServcio;
	
	private UsuarioSession usuarioSession;
	
	@Autowired
	public CitaImplServicio(CitaRepositorio citaRepositorio, TipoCitaServicio tipoCitaServicio,
			TipoUsuarioServicio tipoUsuarioServicio, ParentescoServicio parentescoServicio,
			EstadoServicio estadoServicio, UsuarioServcio usuarioServcio, UsuarioSession usuarioSession) {
		this.citaRepositorio = citaRepositorio;
		this.tipoCitaServicio = tipoCitaServicio;
		this.tipoUsuarioServicio = tipoUsuarioServicio;
		this.parentescoServicio = parentescoServicio;
		this.estadoServicio = estadoServicio;
		this.usuarioServcio = usuarioServcio;
		this.usuarioSession = usuarioSession;
	}

	@Override
	@Transactional(readOnly = false)
	public void guardarCita(Agenda agenda) {
		
		Integer idTipoCita = 1;
		Integer idTipoUsuarioPaciente = 3;
		Integer idTipoUsuarioAcudiente = 4;
		Integer idEstado = 2;
		Integer idParentesco = 1;
		Estado estado = this.estadoServicio.bucarporId(idEstado);
		
		/**
		 * Se procesa el Paciente y el Acudiente
		 */
		agenda.getPaciente().setTipoUsuario(this.tipoUsuarioServicio.buscarPorId(idTipoUsuarioPaciente));
		agenda.getAcudiente().setTipoUsuario(this.tipoUsuarioServicio.buscarPorId(idTipoUsuarioAcudiente));
		agenda.getPaciente().setEstado(estado);
		agenda.getAcudiente().setEstado(estado);
		agenda.getPaciente().setParentesco(this.parentescoServicio.bucarPorId(idParentesco));
		agenda.getPaciente().getAfinidadUsuarios().add(agenda.getAcudiente());
		this.usuarioServcio.guardarUsuario(agenda.getPaciente());
		
		/**
		 * Se procesa la Cita
		 */
		CitaUsuarioId citaUsuarioId = new CitaUsuarioId();
		agenda.getCita().setTipoCita(this.tipoCitaServicio.buscarPorId(idTipoCita));
		agenda.getCita().setEstado(estado);
		citaUsuarioId.setUsuario_idusuapl(this.usuarioSession);
		citaUsuarioId.setUsuario_idusuario(agenda.getPaciente());
		agenda.getCita().setCitaUsuarioId(citaUsuarioId);
		this.citaRepositorio.save(agenda.getCita());
	}

	@Override
	@Transactional(readOnly = true)
	public Cita buscarPorDocumento(String documento) {
		return this.citaRepositorio.findOne(CitaPredicado.buscarPorDocumento(documento));
	}

}
