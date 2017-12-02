package com.olonte.softipac.json;

import java.util.HashSet;
import java.util.Set;

import com.olonte.softipac.modelo.Usuario;

public class UsuarioJSON extends Usuario {
	
	private Set<Usuario> familiares = new HashSet<Usuario>(0);

	public UsuarioJSON() {
	}

	public Set<Usuario> getFamiliares() {
		return familiares;
	}

	public void setFamiliares(Set<Usuario> familiares) {
		this.familiares = familiares;
	}
	
}
