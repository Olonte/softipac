package com.olonte.softipac.impl.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olonte.softipac.modelo.Rol;
import com.olonte.softipac.modelo.Usuario;
import com.olonte.softipac.predicado.UsuarioPredicado;
import com.olonte.softipac.repositorio.UsuarioRepositorio;
import com.olonte.softipac.servicio.UsuarioServcio;

@Service
public class UsuarioImplServicio implements UsuarioServcio {
	
	private UsuarioRepositorio usuarioRepositorio;
	
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

}
