package com.olonte.softipac.modelo;

import java.util.HashSet;
import java.util.Set;

public class UsuarioForma {
	
	private Usuario usuario;
	
	private Set<Rol> roles = new HashSet<Rol>(0);
	
	private boolean javaScript;

	public UsuarioForma() {
	}

	public UsuarioForma(Usuario usuario, Set<Rol> roles, boolean javaScript) {
		this.usuario = usuario;
		this.roles = roles;
		this.javaScript = javaScript;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Set<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}

	public boolean isJavaScript() {
		return javaScript;
	}

	public void setJavaScript(boolean javaScript) {
		this.javaScript = javaScript;
	}
	

}
