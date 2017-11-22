package com.olonte.softipac.impl.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olonte.softipac.modelo.Agenda;
import com.olonte.softipac.modelo.CitaUsuarioId;
import com.olonte.softipac.modelo.Estado;
import com.olonte.softipac.modelo.Rol;
import com.olonte.softipac.modelo.Usuario;
import com.olonte.softipac.predicado.UsuarioPredicado;
import com.olonte.softipac.repositorio.UsuarioRepositorio;
import com.olonte.softipac.servicio.CitaServicio;
import com.olonte.softipac.servicio.EstadoServicio;
import com.olonte.softipac.servicio.ParentescoServicio;
import com.olonte.softipac.servicio.TipoCitaServicio;
import com.olonte.softipac.servicio.TipoUsuarioServicio;
import com.olonte.softipac.servicio.UsuarioServcio;

@Service
public class UsuarioImplServicio implements UsuarioServcio {
	
	private CitaServicio citaServicio;
	
	private UsuarioRepositorio usuarioRepositorio;
	
	private TipoUsuarioServicio tipoUsuarioServicio;
	
	private EstadoServicio estadoServicio;
	
	private TipoCitaServicio tipoCitaServicio;
	
	private ParentescoServicio parentescoServicio;
	
	@Autowired
	public UsuarioImplServicio(UsuarioRepositorio usuarioRepositorio) {
		this.usuarioRepositorio = usuarioRepositorio;
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario bucarPorNombreUsuario(String nombreUsuario) {
		return this.usuarioRepositorio.findOne(UsuarioPredicado.bucarPorNombreUsuario(nombreUsuario));
	}

	@Override
	@Transactional(readOnly = false)
	public void guardarUsuario(Usuario usuario) {
		this.usuarioRepositorio.save(usuario);
	}
	
	@Override
	@Transactional(readOnly = false)
	public void guardarPaciente(Agenda agenda) {
		
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
		agenda.getAucudiente().setTipoUsuario(this.tipoUsuarioServicio.buscarPorId(idTipoUsuarioAcudiente));
		agenda.getPaciente().setEstado(estado);
		agenda.getAucudiente().setEstado(estado);
		agenda.getPaciente().setParentesco(this.parentescoServicio.bucarPorId(idParentesco));
		agenda.getPaciente().getAfinidadUsuarios().add(agenda.getAucudiente());
		guardarUsuario(agenda.getPaciente());
		
		/**
		 * Se procesa la Cita
		 */
		CitaUsuarioId citaUsuarioId = new CitaUsuarioId();
		agenda.getCita().setTipoCita(this.tipoCitaServicio.buscarPorId(idTipoCita));
		agenda.getCita().setEstado(estado);
		citaUsuarioId.setUsuario_idusuapl(bucarPorNombreUsuario(obtenerNombreUsuario()));
		citaUsuarioId.setUsuario_idusuario(agenda.getPaciente());
		agenda.getCita().setCitaUsuarioId(citaUsuarioId);
		this.citaServicio.guardarCita(agenda.getCita());
		
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario bucarPorDocumento(String documento) {
		return obtenerJSON(this.usuarioRepositorio.findOne(UsuarioPredicado.buscarPorDocumento(documento)));
	}
	
	private Usuario obtenerJSON(Usuario usuario) {
		if (usuario != null) {
			Usuario usuarioJSON = new Usuario();
			usuarioJSON = usuario;
			for (Rol rol : usuarioJSON.getRoles()) {
				usuarioJSON.getRoles().add(rol);
			}
			for (Usuario familiar : usuarioJSON.getAfinidadUsuarios()) {
				usuarioJSON.getAfinidadUsuarios().add(familiar);
			}
			return usuarioJSON;
		}else {
			return null;
		}
	}
	
	private String obtenerNombreUsuario() {
		
		Object usuario = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String nombreUsuario = "usdf";
		
		if (usuario instanceof UserDetails) {
			nombreUsuario = ((UserDetails)usuario).getUsername();
		}
		
		return nombreUsuario;
	}

}
