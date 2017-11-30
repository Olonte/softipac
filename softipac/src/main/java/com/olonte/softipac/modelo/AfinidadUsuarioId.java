package com.olonte.softipac.modelo;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Embeddable
public class AfinidadUsuarioId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Usuario usuario_idusuario;
	
	private Usuario idfamiliar;

	public AfinidadUsuarioId() {
	}

	public AfinidadUsuarioId(Usuario usuario_idusuario, Usuario idfamiliar) {
		this.usuario_idusuario = usuario_idusuario;
		this.idfamiliar = idfamiliar;
	}
	
	@ManyToOne
	@JsonBackReference
	public Usuario getUsuario_idusuario() {
		return usuario_idusuario;
	}

	public void setUsuario_idusuario(Usuario usuario_idusuario) {
		this.usuario_idusuario = usuario_idusuario;
	}
	
	@ManyToOne
	@JsonBackReference
	public Usuario getIdfamiliar() {
		return idfamiliar;
	}

	public void setIdfamiliar(Usuario idfamiliar) {
		this.idfamiliar = idfamiliar;
	}

}
