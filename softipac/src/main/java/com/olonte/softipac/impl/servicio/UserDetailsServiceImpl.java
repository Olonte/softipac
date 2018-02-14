package com.olonte.softipac.impl.servicio;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olonte.softipac.modelo.Rol;
import com.olonte.softipac.modelo.Usuario;
import com.olonte.softipac.modelo.UsuarioLoqueado;
import com.olonte.softipac.predicado.UsuarioPredicado;
import com.olonte.softipac.repositorio.UsuarioRepositorio;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private UsuarioRepositorio usuarioRepositorio;
	
	@Autowired
	public UserDetailsServiceImpl(UsuarioRepositorio usuarioRepositorio) {
		this.usuarioRepositorio = usuarioRepositorio;
	}

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Usuario usuario = this.usuarioRepositorio.findOne(UsuarioPredicado.bucarPorNombreUsuario(username));
		
		if (usuario == null) {
			throw new UsernameNotFoundException("Usuario no encontrado");
		}
		
		return new UsuarioLoqueado(usuario.getNombreUsuario(), usuario.getPassword() , getGrantedAuthorities(usuario), usuario);
	}
	
	private Set<GrantedAuthority> getGrantedAuthorities(Usuario usuario) {
		Set<GrantedAuthority> authorities = new HashSet<>();
		for (Rol rol : usuario.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(rol.getRol()));
		}
		
		return authorities;
	}

}
