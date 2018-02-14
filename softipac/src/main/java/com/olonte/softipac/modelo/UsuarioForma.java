package com.olonte.softipac.modelo;

import java.util.HashSet;
import java.util.Set;

public class UsuarioForma {
	
	private Usuario usuario;
	
	private Set<Rol> roles = new HashSet<Rol>(0);
	
	private boolean javaScript;
	
	private String passwordTemp;

	public UsuarioForma() {
	}

	public UsuarioForma(Usuario usuario, Set<Rol> roles, boolean javaScript, String passwordTemp) {
		this.usuario = usuario;
		this.roles = roles;
		this.javaScript = javaScript;
		this.passwordTemp = passwordTemp;
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

	public String getPasswordTemp() {
		return passwordTemp;
	}

	public void setPasswordTemp(String passwordTemp) {
		this.passwordTemp = passwordTemp;
	}

}
