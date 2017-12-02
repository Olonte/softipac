package com.olonte.softipac.impl.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.olonte.softipac.json.JSON;
import com.olonte.softipac.json.UsuarioJSON;
import com.olonte.softipac.modelo.Diagnostico;
import com.olonte.softipac.modelo.Usuario;
import com.olonte.softipac.predicado.UsuarioPredicado;
import com.olonte.softipac.repositorio.UsuarioRepositorio;
import com.olonte.softipac.servicio.UsuarioServicio;

@Service
public class UsuarioImplServicio implements UsuarioServicio {
	
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
	public void guardar(Usuario usuario) {
		this.usuarioRepositorio.save(usuario);
	}
	
	@Override
	@Transactional(readOnly = true)
	public UsuarioJSON bucarPorDocumento(String documento) {
		return JSON.obtenerUsuarioJSON(this.usuarioRepositorio.findOne(UsuarioPredicado.buscarPorDocumento(documento)));
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
	public Usuario buscarAcudientePorId(Integer idUsuario) {
		return this.usuarioRepositorio.findOne(UsuarioPredicado.buscarPorIdUsuario(idUsuario));
	}

}
