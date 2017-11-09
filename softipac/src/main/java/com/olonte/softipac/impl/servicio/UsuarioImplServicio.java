package com.olonte.softipac.impl.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olonte.softipac.modelo.CitaFormulario;
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
		return this.usuarioRepositorio.findOne(UsuarioPredicado.buscarUsuarioPredicado(nombreUsuario));
	}

	@Override
	@Transactional(readOnly = false)
	public void guardarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
	}

	@Override
	public void guardarPaciente(CitaFormulario citaFormulario) {
		// TODO Auto-generated method stub
		
	}

}
