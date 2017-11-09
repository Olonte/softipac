package com.olonte.softipac.modelo;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class CitaUsuarioId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Usuario usuario_idusuapl;
	
	private Usuario usuario_idusuario;

	public CitaUsuarioId() {
	}
	
	public CitaUsuarioId(Usuario usuario_idusuapl, Usuario usuario_idusuario) {
		this.usuario_idusuapl = usuario_idusuapl;
		this.usuario_idusuario = usuario_idusuario;
	}

	@ManyToOne
	public Usuario getUsuario_idusuapl() {
		return usuario_idusuapl;
	}

	public void setUsuario_idusuapl(Usuario usuario_idusuapl) {
		this.usuario_idusuapl = usuario_idusuapl;
	}
	
	@ManyToOne
	public Usuario getUsuario_idusuario() {
		return usuario_idusuario;
	}

	public void setUsuario_idusuario(Usuario usuario_idusuario) {
		this.usuario_idusuario = usuario_idusuario;
	}
	
	
}
