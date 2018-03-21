package com.olonte.softipac.impl.servicio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olonte.softipac.json.JSON;
import com.olonte.softipac.json.UsuarioJSON;
import com.olonte.softipac.modelo.Afinidad;
import com.olonte.softipac.modelo.Diagnostico;
import com.olonte.softipac.modelo.Rol;
import com.olonte.softipac.modelo.Usuario;
import com.olonte.softipac.modelo.UsuarioForma;
import com.olonte.softipac.predicado.UsuarioPredicado;
import com.olonte.softipac.repositorio.UsuarioRepositorio;
import com.olonte.softipac.servicio.EstadoServicio;
import com.olonte.softipac.servicio.UsuarioServicio;
import com.olonte.softipac.utilidad.Utilidad;

@Service
public class UsuarioImplServicio implements UsuarioServicio {
	
	private UsuarioRepositorio usuarioRepositorio;
	
	private EstadoServicio estadoServicio;
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	public UsuarioImplServicio(UsuarioRepositorio usuarioRepositorio, EstadoServicio estadoServicio) {
		this.usuarioRepositorio = usuarioRepositorio;
		this.estadoServicio = estadoServicio;
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario bucarPorNombreUsuario(String nombreUsuario) {
		return this.usuarioRepositorio.findOne(UsuarioPredicado.bucarPorNombreUsuario(nombreUsuario));
	}

	@Override
	@Transactional(readOnly = false)
	public void guardar(Usuario usuario) {
		this.usuarioRepositorio.save(usuario);
	}
	
	@Override
	@Transactional(readOnly = true)
	public UsuarioJSON bucarPorDocumento(String parametros) {	
		return JSON.obtenerUsuarioJSON(this.usuarioRepositorio.findOne(UsuarioPredicado.buscarPorDocumento(parametros)));
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario buscarPacientePorId(Integer idUsuario) {
		Usuario paciente = this.usuarioRepositorio.findOne(idUsuario);
		for (Diagnostico diagnostico : paciente.getDiagnosticos()) {
			paciente.getDiagnosticos().add(diagnostico);
		}
		return paciente;
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario buscarAcudientePorId(Integer idUsuario, Integer idTipoUsuario) {
		return this.usuarioRepositorio.findOne(UsuarioPredicado.buscarAcudientePorId(idUsuario,idTipoUsuario));
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario buscarFamiliarPorId(Integer idUsuario, Integer idParentesco) {
		return this.usuarioRepositorio.findOne(UsuarioPredicado.buscarFamiliarPorId(idUsuario, idParentesco));
	}

	@Override
	@Transactional(readOnly = false)
	public void guardar(UsuarioForma usuarioForma, Integer idEstado) {
		usuarioForma.getUsuario().setEstado_idestado(this.estadoServicio.bucarporId(idEstado));
		if (usuarioForma.isJavaScript()) {
			guardarRol(usuarioForma);
		}
		this.usuarioRepositorio.save(usuarioForma.getUsuario());
	}

	@Override
	@Transactional(readOnly = true)
	public List<Usuario> buscarPorIdTipoUsuario(Integer idTipoUsuarioApl, Integer idTipoUsuariSis) {
		return (List<Usuario>) this.usuarioRepositorio.findAll(UsuarioPredicado.buscarPorIdTipoUsuario(idTipoUsuarioApl,idTipoUsuariSis));
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario buscarPorId(Integer idUsuario) {
		Usuario usuario = this.usuarioRepositorio.findOne(idUsuario);
		for(Rol rol : usuario.getRoles()) {
			usuario.getRoles().add(rol);
		}
		return usuario;
	}

	@Override
	@Transactional(readOnly = false)
	public void cambiarEstadoUsuario(Integer idUsuario, Integer idEstado) {
		UsuarioPredicado.cambiarEstadoUsuario(entityManager, idUsuario, idEstado);
		
	}
	
	private void guardarRol(UsuarioForma usuarioForma) {
		if (usuarioForma.getUsuario().getRoles().isEmpty()) {
			usuarioForma.getUsuario().setRoles(this.usuarioRepositorio.findOne(usuarioForma.getUsuario().getIdUsuario()).getRoles());
		}else {
			usuarioForma.getUsuario().getRoles().addAll(this.usuarioRepositorio.findOne(usuarioForma.getUsuario().getIdUsuario()).getRoles());
		}
	}

	@Override
	public Usuario buscarPorId(Usuario usuario) {
		for (Diagnostico diagnostico : usuario.getDiagnosticos()) {
			usuario.getDiagnosticos().add(diagnostico);
		}
		return usuario;
	}

	@Override
	public Usuario buscarAcudientePorId(Usuario paciente) {		
		Usuario acudiente = new Usuario();		
		for (Afinidad afinidad : paciente.getUsuario_idusuario()) {
			for (Afinidad acudiente_af : afinidad.getAfinidadUsuarioId().getUsuario_idusuario().getUsuario_idusuario()) {			
				if (acudiente_af.getAfinidadUsuarioId().getIdfamiliar().getTipousuario_idtipousuario().getIdTipoUsuario() == Utilidad.USUARIO_ACUDIENTE) {
					acudiente = acudiente_af.getAfinidadUsuarioId().getIdfamiliar();
					break;
				}			
			}						
		}
		return acudiente;
	}

	@Override
	public Usuario buscarFamiliarPorId(Usuario paciente, Integer idParentesco) {
		Usuario familiar = new Usuario();
		for (Afinidad afinidad : paciente.getUsuario_idusuario()) {
			for (Afinidad familiar_af : afinidad.getAfinidadUsuarioId().getUsuario_idusuario().getUsuario_idusuario()) {			
				if (familiar_af.getAfinidadUsuarioId().getIdfamiliar().getParentesco_idparentesco().getIdParentesco() == idParentesco ) {
					familiar = familiar_af.getAfinidadUsuarioId().getIdfamiliar();
					break;
				}			
			}						
		}		
		return familiar;
	}

}
