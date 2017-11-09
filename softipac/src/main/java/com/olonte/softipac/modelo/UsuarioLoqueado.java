package com.olonte.softipac.modelo;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class UsuarioLoqueado extends User {
	
	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;

	public UsuarioLoqueado(String username, String password, boolean enabled, boolean accountNonExpired,
			boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		
	}

	public UsuarioLoqueado(String username, String password, Collection<? extends GrantedAuthority> authorities, Usuario usuario) {
		super(username, password, authorities);
		this.usuario = usuario;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
